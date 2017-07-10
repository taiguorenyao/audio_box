package com.audio.core.dao.data;

import com.audio.core.entity.AcessLog;
import com.audio.core.entity.BaseRedis;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by taiguorenyao on 2017/1/10.
 * e-mail: ooxx@Live.cn
 */
@Repository
public class DataDaoImpl implements DataDao
{

    @Resource(name = "sqlSession1")
    public SqlSessionTemplate sqlSession;

    public void saveDataLog(AcessLog acessLog)
    {
        sqlSession.insert("Data.saveAccessLog", acessLog);
    }

    public int getListSize(int type, String... str)
    {
        if (1 == type)
        {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("startTime", str[0]);
            map.put("endTime", str[1]);
            return (Integer) sqlSession.selectOne("Data.getClickListSize", map);
        }

        if (2 == type)
        {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("startTime", str[0]);
            map.put("endTime", str[1]);
            map.put("uid", str[2]);
            return (Integer) sqlSession.selectOne("Data.getMyClickListSize", map);
        }

        return 0;
    }

    public List<? extends BaseRedis> getList(int type, int pageStart,
            int pageSize, String... str)
    {
        if (1 == type)
        {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("curPage", pageStart);
            map.put("pageSize", pageSize);
            map.put("startTime", str[0]);
            map.put("endTime", str[1]);
            return sqlSession.selectList("Data.getClickList",
                    map);
        }

        if (2 == type)
        {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("curPage", pageStart);
            map.put("pageSize", pageSize);
            map.put("startTime", str[0]);
            map.put("endTime", str[1]);
            map.put("uid", str[2]);
            return sqlSession.selectList("Data.getMyClickList",
                    map);
        }

        return null;
    }

}

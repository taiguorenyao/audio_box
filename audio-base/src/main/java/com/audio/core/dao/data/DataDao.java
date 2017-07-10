package com.audio.core.dao.data;

import com.audio.core.entity.AcessLog;
import com.audio.core.entity.AcessStatistical;
import com.audio.core.entity.BaseRedis;
import com.audio.util.PaginationSupport;

import java.util.List;

/**
 * Created by taiguorenyao on 2017/1/10.
 * e-mail: ooxx@Live.cn
 */
public interface DataDao
{

    void saveDataLog(AcessLog acessLog);

    int getListSize(int type,String... str);

    List<? extends BaseRedis> getList(int type, int pageStart, int pageSize, String... str);
}

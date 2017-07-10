package com.audio.core.service.data;

import com.audio.core.dao.data.DataDao;
import com.audio.core.entity.AcessLog;
import com.audio.core.entity.AcessStatistical;
import com.audio.core.entity.Domain;
import com.audio.util.PaginationSupport;
import com.audio.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by taiguorenyao on 2017/1/5.
 * e-mail: ooxx@Live.cn
 */
@Service(value = "dataService")
public class DataServiceImpl implements DataService
{
    @Resource
    private DataDao dataDao;

    public void saveAccessLog(AcessLog acessLog)
    {
        dataDao.saveDataLog(acessLog);
    }

    public PaginationSupport<AcessStatistical> getClickList(
            int beginPage, int pageSize, String... str)
    {

        PaginationSupport<AcessStatistical> pageList = new PaginationSupport<AcessStatistical>();
        List<AcessStatistical> vList = null;
        int count = 0;
        int totalPage = 0;
        try
        {
            //查询总条数
            count = dataDao.getListSize(1,str);
            if (count == 0)
            {
                return null;
            }
            //得到总页数
            totalPage = StringUtil.getTotalPage(count, pageSize);

            //如果当前页大于总页数，自动跳最后一页
            if (beginPage > totalPage)
            {
                beginPage = totalPage;
            }

            int startPage = 0;
            int endPage = pageSize;
            if (beginPage == 1)
            {
                startPage = 0;
            }
            else
            {
                startPage = (beginPage - 1) * pageSize;
            }

            vList = (List<AcessStatistical>) dataDao.getList(1,
                    startPage,
                    endPage,
                    str);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

        pageList.setItems(vList);
        pageList.setTotalRecord(String.valueOf(count));
        pageList.setCurPage(String.valueOf(beginPage));
        pageList.setPageSize(String.valueOf(pageSize));
        pageList.setParams("/sys/clicklist");
        return pageList;
    }


    public PaginationSupport<AcessStatistical> getMyClickList(
            int beginPage, int pageSize, String... str)
    {

        PaginationSupport<AcessStatistical> pageList = new PaginationSupport<AcessStatistical>();
        List<AcessStatistical> vList = null;
        int count = 0;
        int totalPage = 0;
        try
        {
            //查询总条数
            count = dataDao.getListSize(2,str);
            if (count == 0)
            {
                return null;
            }
            //得到总页数
            totalPage = StringUtil.getTotalPage(count, pageSize);

            //如果当前页大于总页数，自动跳最后一页
            if (beginPage > totalPage)
            {
                beginPage = totalPage;
            }

            int startPage = 0;
            int endPage = pageSize;
            if (beginPage == 1)
            {
                startPage = 0;
            }
            else
            {
                startPage = (beginPage - 1) * pageSize;
            }

            vList = (List<AcessStatistical>) dataDao.getList(2,
                    startPage,
                    endPage,
                    str);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

        pageList.setItems(vList);
        pageList.setTotalRecord(String.valueOf(count));
        pageList.setCurPage(String.valueOf(beginPage));
        pageList.setPageSize(String.valueOf(pageSize));
        pageList.setParams("/my/clicklist");
        return pageList;
    }
}

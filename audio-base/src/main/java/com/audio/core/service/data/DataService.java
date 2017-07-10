package com.audio.core.service.data;

import com.audio.core.entity.AcessLog;
import com.audio.core.entity.AcessStatistical;
import com.audio.core.entity.Domain;
import com.audio.util.PaginationSupport;

/**
 * Created by taiguorenyao on 2017/1/5.
 * e-mail: ooxx@Live.cn
 */
public interface DataService
{
    void saveAccessLog(AcessLog acessLog);

    PaginationSupport<AcessStatistical> getClickList(
            int beginPage, int pageSize, String... str);

    PaginationSupport<AcessStatistical> getMyClickList(
            int beginPage, int pageSize, String... str);
}

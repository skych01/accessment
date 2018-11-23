package com.hhxk.assessment.service;

import com.hhxk.assessment.util.Page;

public interface LogService {
    void writeLog(String logType, int userId,
                  String ip, String opDesc, String extInfo);

    Page pageSQLQuery(String sql, int pageNo, int pageSize, long totalCount, Object... values);
}

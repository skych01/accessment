package com.hhxk.assessment.service;



import com.hhxk.assessment.entity.base.DLog;
import com.hhxk.assessment.repository.DLogRepository;
import com.hhxk.assessment.repository.SysUserRepository;
import com.hhxk.assessment.util.Page;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaoq on 2017-06-14.
 */
@Service
public class LogServiceImp implements LogService {
    @Autowired
    private DLogRepository logRepository;

    @Autowired
    private SysUserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public void writeLog(String logType, int userId, String ip, String opDesc, String extInfo) {
        DLog log = new DLog(logType, userId, ip, opDesc, extInfo);
        logRepository.saveAndFlush(log);
    }

    @Override
    public Page pageSQLQuery(String sql, int pageNo, int pageSize, long totalCount, Object... values) {
        Session session = entityManager.unwrap(Session.class);

        Object [] params = values;

        if(totalCount<0){
            SQLQuery query = session.createSQLQuery("select count(*) "+sql);

            for(int i=0;i < params.length ; i++){
                query.setParameter(i, params[i]);
            }

            Object obj = query.uniqueResult();
            totalCount = Long.parseLong(obj.toString());
        }

        if (totalCount < 1) {
            return new Page();
        } else {
            int startIndex = Page.getStartOfPage(pageNo, pageSize);
            SQLQuery query = session.createSQLQuery("select *  "+sql);

            for(int i=0;i < params.length ; i++){
                query.setParameter(i, params[i]);
            }

            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            List<Map<String, Object>> list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();

            if (totalCount < 1)
                return new Page();
            return new Page(startIndex, totalCount, pageSize, list);
        }
    }
}

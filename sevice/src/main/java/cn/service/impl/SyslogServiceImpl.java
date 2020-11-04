package cn.service.impl;

import cn.dao.ISyslogDao;
import cn.pojo.SysLog;
import cn.service.ISyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SyslogServiceImpl implements ISyslogService {
    @Autowired
    private ISyslogDao iSyslogDao;
    @Override
    public void save(SysLog sysLog) {
        iSyslogDao.save(sysLog);
    }
}

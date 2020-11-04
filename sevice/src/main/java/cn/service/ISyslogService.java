package cn.service;

import cn.pojo.SysLog;
import org.springframework.stereotype.Service;


public interface ISyslogService {
    void save(SysLog sysLog);
}

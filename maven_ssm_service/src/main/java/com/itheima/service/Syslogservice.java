package com.itheima.service;

import com.itheima.domain.SysLog;

import java.util.List;

public interface Syslogservice {
    void  save(SysLog sysLog);
    List<SysLog> findAll(Integer page,Integer size);
}

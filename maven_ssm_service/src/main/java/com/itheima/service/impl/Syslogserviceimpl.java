package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.Syslogdao;
import com.itheima.domain.SysLog;
import com.itheima.service.Syslogservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Syslogserviceimpl implements Syslogservice {
    @Autowired
    private Syslogdao syslogdao;
    @Override
    public void save(SysLog sysLog) {
         syslogdao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        return syslogdao.findAll();
    }
}

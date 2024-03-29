package com.itheima.dao;

import com.itheima.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Syslogdao {
    @Select("select * from syslog")
    public List<SysLog> findAll();

    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method)values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog);
}

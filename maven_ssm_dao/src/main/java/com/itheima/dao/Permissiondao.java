package com.itheima.dao;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Permissiondao {
    @Select("select * from permission")
    List<Permission> findAll();

    @Select("select * from permission where id =#{id}")
    Permission findByid(String id);

    @Delete("delete from permission where id =#{id}")
      void delete  (String id);
    @Delete("delete from role_permission where permissionid =#{permissionid} ")
     void deletefromrp(String id);
    @Select("select * from  permission  where id in (select  permissionId from  role_permission where roleId =#{id})")
    List<Permission> findroleId(String id);


}


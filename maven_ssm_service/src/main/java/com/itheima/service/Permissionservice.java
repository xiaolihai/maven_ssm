package com.itheima.service;

import com.itheima.domain.Permission;


import java.util.List;

public interface Permissionservice  {

    List<Permission> findAll();


    Permission findByid(String id);

    void delete(String id);
}

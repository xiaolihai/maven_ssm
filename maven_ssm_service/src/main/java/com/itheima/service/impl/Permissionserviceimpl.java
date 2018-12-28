package com.itheima.service.impl;

import com.itheima.dao.Permissiondao;
import com.itheima.domain.Permission;
import com.itheima.service.Permissionservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class Permissionserviceimpl implements Permissionservice {
    @Autowired
    private Permissiondao permissiondao;
    @Override
    public List<Permission> findAll() {
        return permissiondao.findAll();
    }

    @Override
    public Permission findByid(String id) {
        return permissiondao.findByid(id);
    }

    @Override
    public void delete(String id) {
        permissiondao.deletefromrp(id);
        permissiondao.delete(id);
    }

}

package com.itheima.service.impl;

import com.itheima.dao.Roledao;
import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.service.Roleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class Roleserviceimpl implements Roleservice {
    @Autowired
    private Roledao roledao;
    @Override
    public List<Role> findAll() {
        return roledao.findAll();
    }

    @Override
    public void save(Role role) {
        roledao.save(role);
    }

    @Override
    public void delete(String id) {
        roledao.deleterolepermission(id);
        roledao.deleteroleusersrole(id);
        roledao.deleteroleByid(id);
    }

    @Override
    public List<Permission> findOtherPermission(String id) {
        return roledao.findOtherPermission(id);
    }

    @Override
    public Role findByid(String id) {
        return roledao.findByid(id);
    }

    @Override
    public void RoleToPermisson(String roleid, String[] permissions) {
        for (String permission : permissions) {
            roledao.RoleToPermission(roleid,permission);
        }
    }


}

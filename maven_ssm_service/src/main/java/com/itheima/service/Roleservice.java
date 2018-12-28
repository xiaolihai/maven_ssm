package com.itheima.service;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;

import java.util.List;

public interface Roleservice {
    List<Role> findAll();
    void save(Role role);
    void delete(String id);
    List<Permission> findOtherPermission(String id);
    Role findByid(String id);
    void RoleToPermisson(String roleid, String[] permissions);
}

package com.itheima.service;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface Userservice extends UserDetailsService {
    List<UserInfo> findAll();
    void save(UserInfo userInfo);
    UserInfo  findByid(String id);
    List<Role> findOtherrole(String id);
    void UserToroles(String userId,String[] roles);

}

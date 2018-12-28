package com.itheima.service.impl;

import com.itheima.dao.Userdao;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.Userservice;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class Userserviceimpl implements Userservice {
    @Autowired
   private Userdao  userdao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         UserInfo info=null;
           User user = null;
        try {
            info = userdao.findUsername(username);
            if(info!=null)
                user = new User(info.getUsername(),info.getPassword(),info.getStatus()== 0? false: true,true,true,true,getAuthority(info.getRoles()));

        } catch (Exception e) {
            e.printStackTrace();
        }


        return  user;

    }
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
          List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }

          return list;
    }

    @Override
    public List<UserInfo> findAll() {
        return userdao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userdao.save(userInfo);
    }

    @Override
    public UserInfo findByid(String id) {
        return userdao.findByid(id);
    }

    @Override
    public List<Role> findOtherrole(String id) {
        return userdao.findOtherroles(id);
    }

    @Override
    public void UserToroles(String userId, String[] roles) {
        for (String role : roles) {
            userdao.UserToroles(userId,role);
        }
    }

}

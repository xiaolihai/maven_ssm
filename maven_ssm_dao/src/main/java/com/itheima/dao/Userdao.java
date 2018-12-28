package com.itheima.dao;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Userdao  {
    @Select("select * from users where username = #{username}")
    @Results(value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id" ,property = "roles", many=@Many(select = "com.itheima.dao.Roledao.findByuserid"))

    })
    UserInfo findUsername( String username);
     @Select("select * from users")
    List<UserInfo>findAll();
     @Insert("insert into users (email,username,password,phoneNum,status)values(#{email},#{username},#{password},#{phoneNum},#{status})")
     void save(UserInfo userInfo);

     @Select("select * from users where id =#{id}")
    /* @ResultMap("userMap")*/
     @Results(value = {
             @Result(id = true,column = "id",property = "id"),
             @Result(column = "email", property = "email"),
             @Result(column = "password", property = "password"),
             @Result(column = "phoneNum", property = "phoneNum"),
             @Result(column = "status", property = "status"),
             @Result(column = "id" ,property = "roles", many=@Many(select = "com.itheima.dao.Roledao.findRoleByUserId"))

     })
     UserInfo  findByid(String id);

     @Select("select * from role where id not in (select  roleId from users_role where userid=#{id})")
    List<Role> findOtherroles (String id);
     @Insert("insert into users_role (userId,roleId)values(#{userId},#{roleId})")
     void UserToroles(@Param("userId") String userId,@Param("roleId") String roleId);
}

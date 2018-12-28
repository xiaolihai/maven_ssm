package com.itheima.dao;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Roledao {
     @Select("select * from role where id in  (select roleId from users_role where userId=#{userId})")
    List<Role> findByuserid(String userid);
     @Select("select * from role")
     List<Role> findAll();
     @Insert("insert into role (roleName,roleDesc)values(#{roleName},#{roleDesc})")
     void  save(Role role);
     @Delete("delete from role where id = #{id}")
     void deleteroleByid(String id);
     @Delete("delete from role_permission where roleId=#{roleId} ")
     void deleterolepermission(String id);
     @Delete("delete from users_role where  roleId=#{roleId}")
     void deleteroleusersrole(String id);

/*     @Select("select * from role where id in (select roleId from users_role where userID =#{id})")
     @Results({
             @Result(id = true,column = "id",property = "id"),
             @Result(column = "roleName",property ="roleName" ),
             @Result(column = "roleDesc",property = "roleDesc"),
             @Result(column = "id",property = "permissions",many = @Many(select = "com.itheima.dao.Permissiondao.findroleId"))
     })*/
    /* @Select("select * from role where id in (select roleId from users_role where userID =#{userid})")
     @Results({
             @Result(id=true,property = "id",column = "id"),
             @Result(property = "roleName",column = "roleName"),
             @Result(property = "roleDesc",column = "roleDesc"),
             @Result(property = "permissions",column = "id",
                     many = @Many(select = "com.itheima.dao.Permissiondao.findroleId"),javaType = java.util.List.class)
     })

     List<Role> findRoleUserByid(String userid);*/

    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.dao.Permissiondao.findroleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;

    @Select("select * from permission where id not in (select permissionID from ROLE_PERMISSION where roleId=#{id})")
    List<Permission>findOtherPermission(String id);
    @Select("select * from role where id = #{id}")
    Role findByid(String id);
   @Insert("insert into ROLE_PERMISSION (permissionId,roleid)values(#{permissionId},#{roleId})")
    void RoleToPermission(@Param("roleId") String roleId,@Param("permissionId") String permissionId);
}

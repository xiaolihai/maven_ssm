package com.itheima.dao;

import com.itheima.domain.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Ordersdao {
    @Select("select * from orders")
    @Results({
            @Result(id = true,column = "id" ,property = "id"),
            @Result(column = "orderNum" , property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc" ,property = "orderDesc"),
            @Result(column = "productId" ,property = "product",one = @One(select = "com.itheima.dao.Productdao.findByid"))
    })
    List<Orders> findAll();


    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "orderNum" , property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc" ,property = "orderDesc"),
            @Result(column = "productId" ,property = "product",one = @One(select = "com.itheima.dao.Productdao.findByid")),
            @Result(column = "id" ,property = "travellers", many= @Many(select = "com.itheima.dao.Travellerdao.findByOrdersId")),
            @Result(column = "memberId" ,property = "member",one = @One(select = "com.itheima.dao.Memberdao.findById")),


    })
    Orders findByid(String id);

}

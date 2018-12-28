package com.itheima.dao;

import com.itheima.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.Array;
import java.util.List;

public interface Productdao  {
      @Select("select * from product")
      List<Product> findAll();
    //  @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)" + "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus}")


      @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
      void  save(Product product);

      @Select("select * from product where id = #{id}")
      Product findByid(String id);

      @Delete("delete from product where id = #{id}")
      void delete(String id);
}

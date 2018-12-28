package com.itheima.dao;

import com.itheima.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Travellerdao {
  /*  @Select("select t.* from traveller t  ,order_traveller ot where ot.travellerid=t.id and ot.orderid = #{id}")
       List<Traveller> findByid(String  id);*/
  @Select("select t.* from order_traveller ot, traveller t where ot.travellerId=t.id and  ot.orderId=#{id}")
  List<Traveller> findByOrdersId(String id);
}

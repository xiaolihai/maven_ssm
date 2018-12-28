package com.itheima.dao;

import com.itheima.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface Memberdao {
   /* @Select("select * from member where id=#{id}")
    Member findByid(String id);*/
   @Select("select * from member where id=#{id}")
   Member findById(String id);
}

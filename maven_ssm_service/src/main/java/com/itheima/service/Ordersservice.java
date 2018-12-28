package com.itheima.service;

import com.itheima.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface Ordersservice {
    List<Orders> findAllByPage(int page, int pageSize);
    Orders findByid(String id);
}

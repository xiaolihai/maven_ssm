package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.Ordersdao;
import com.itheima.domain.Orders;
import com.itheima.service.Ordersservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class Ordersserviceimpl implements Ordersservice {
    @Autowired
     private  Ordersdao  ordersdao ;

    @Override
    public List<Orders> findAllByPage(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        return ordersdao.findAll();
    }

    @Override
    public Orders findByid(String id) {

        return ordersdao.findByid(id);
    }
}

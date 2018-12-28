package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.Productdao;
import com.itheima.domain.Product;
import com.itheima.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class Productserviceimpl implements Productservice {
    @Autowired
    private Productdao productdao;
    @Override
    public List<Product> findAll(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        return productdao.findAll();
    }

    @Override
    public void save(Product product) {
        productdao.save(product);
    }

    @Override
    public void delete(String id) {
        productdao.delete(id);
    }


}

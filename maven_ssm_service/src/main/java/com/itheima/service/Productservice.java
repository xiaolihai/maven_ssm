package com.itheima.service;

import com.itheima.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Productservice {
    List<Product>  findAll(Integer page,Integer size);

    void  save(Product product);

    void  delete(String id);
}

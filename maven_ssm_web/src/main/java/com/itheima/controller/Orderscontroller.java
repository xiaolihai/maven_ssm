package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.service.Ordersservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class Orderscontroller {
    @Autowired
    private Ordersservice ordersservice;
    @RequestMapping("/findAll.do")
    public ModelAndView findPage(@RequestParam(name = "page",defaultValue = "1",required = true)Integer page,
                                 @RequestParam(name = "size",defaultValue ="10",required = true) Integer size){
        List<Orders> orders = ordersservice.findAllByPage(page, size);
        PageInfo pageInfo = new PageInfo(orders,10);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-page-list");
        mv.addObject("pageInfo",pageInfo);
        return mv ;
    }
    @RequestMapping("/findById.do")
    public ModelAndView findByid(String id){
        Orders orders = ordersservice.findByid(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-show");
        mv.addObject("orders",orders);
        return mv;

    }
}

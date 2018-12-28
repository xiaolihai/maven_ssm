package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.dao.Productdao;
import com.itheima.domain.Product;
import com.itheima.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class Productcontroller {
    @Autowired
    private Productservice productservice;
    @RequestMapping("/save.do")
    public String save(Product product){
        productservice.save(product);
        return "redirect:findAll.do";
    }


    @RequestMapping("/findAll.do")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1",required = true)Integer page,
                                @RequestParam(name = "size",defaultValue ="10",required = true) Integer size){
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productservice.findAll(page,size);
        PageInfo pageInfo = new PageInfo(productList, 10);
        mv.addObject("pageInfo",pageInfo);
      mv.setViewName("product-list");
        return mv;
    }
    @RequestMapping("/Delete.do")
    public String delete(@RequestParam(name = "arr") String id){
        productservice.delete(id);
        return "product-list";
    }
}

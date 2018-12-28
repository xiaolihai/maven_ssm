package com.itheima.controller;

import com.itheima.domain.Permission;
import com.itheima.service.Permissionservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class Permissioncontroller {
    @Autowired private Permissionservice permissionservice;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Permission> list = permissionservice.findAll();
        mv.addObject("permissionList",list);
        mv.setViewName("permission-list");
        return mv;
    }
    @RequestMapping("/findById.do")
    public ModelAndView findByid(String id){
        Permission byid = permissionservice.findByid(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("permission",byid);
        mv.setViewName("permission-show");
        return mv;
    }
    @RequestMapping("/deletePermission.do")
    public String delete(String id){
        permissionservice.delete(id);
        return "redirect:findAll.do";
    }

}

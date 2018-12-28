package com.itheima.controller;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.service.Roleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class Rolecontroller {
    @Autowired
    private Roleservice roleservice;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleservice.findAll();
        mv.setViewName("role-list");
        mv.addObject("roleList",roles);
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(Role role){
         roleservice.save(role);
        return "redirect:findAll.do";
    }
    @RequestMapping("/deleteRole.do")
    public  String delete(String id){
        roleservice.delete(id);
        return "redirect:findAll.do";
    }
   @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(String id){
       List<Permission> permissions = roleservice.findOtherPermission(id);
       Role role = roleservice.findByid(id);
       ModelAndView mv = new ModelAndView();
       mv.addObject("role",role);
       mv.addObject("permissionList",permissions);
       mv.setViewName("role-permission-add");
       return mv;
   }
   @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true) String roleid,
                                      @RequestParam(name = "ids",required = true) String[] permissions)
   {
         roleservice.RoleToPermisson(roleid,permissions);
        return "redirect:findAll.do";
   }
}

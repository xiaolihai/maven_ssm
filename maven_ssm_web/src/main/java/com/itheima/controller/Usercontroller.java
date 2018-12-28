package com.itheima.controller;

import com.itheima.dao.Roledao;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.Roleservice;
import com.itheima.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class Usercontroller {
   @Autowired
    private Userservice userservice;
   @RequestMapping("/findAll.do")
   @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView findAll(){
       ModelAndView mv = new ModelAndView();
       List<UserInfo> list = userservice.findAll();
       mv.addObject("userList",list);
       mv.setViewName("user-list");
       return mv;
   }
   @RequestMapping("/save.do")
   @PreAuthorize("authentication.principal.username == 'liuweixin'")
   public String save(UserInfo userInfo){
        userservice.save(userInfo);
         return "redirect:findAll.do";

   }
    @RequestMapping("/findById.do")
    public ModelAndView findByid(String id){

        UserInfo byid = userservice.findByid(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",byid);
        mv.setViewName("user-show1");
        return mv;

    }
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id){
        UserInfo info = userservice.findByid(id);
        List<Role> roles = userservice.findOtherrole(id);
        ModelAndView mv = new ModelAndView();
         mv.addObject("user",info);
         mv.addObject("roleList",roles);
         mv.setViewName("user-role-add");
        return mv;
    }
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true)String userId, @RequestParam(name = "ids",required = true)String[] roles)
    {
         userservice.UserToroles(userId,roles);
          return "redirect:findAll.do";
    }
}

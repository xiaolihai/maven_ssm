package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.SysLog;
import com.itheima.service.Syslogservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class Syslogcontroller {
    @Autowired
    private Syslogservice syslogservice;
    @Autowired
    private  HttpServletRequest request;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1",required = true)Integer page,
                                @RequestParam(name = "size",defaultValue ="10",required = true) Integer size){
        List<SysLog> sysLogList = syslogservice.findAll(page,size);
        ModelAndView mv = new ModelAndView();
        PageInfo pageInfo = new PageInfo(sysLogList, 10);
        mv.addObject("pageInfo",pageInfo);
         mv.setViewName("syslog-list");
        /*String url = request.getRequestURL().toString();
        mv.addObject("url",url);*/

        return mv;

    }
}

package com.lostself.hkspringboot.controller;

import com.github.pagehelper.PageInfo;
import com.lostself.hkspringboot.entity.SysUser;
import com.lostself.hkspringboot.entity.Test;
import com.lostself.hkspringboot.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private Test test;

    @RequestMapping("/user")
    public SysUser getUser() {
        return sysUserService.findById(1L);
    }
    @RequestMapping ("/hello")
    public String hello(){
        return "hello";
    }

    @Value("${blog.login.name}")
    private String name;

    @Value("${spring.datasource.driverClassName}")
    private String pass;

    @GetMapping("/test")
    @ResponseBody
    public String configtest(){

        return "neme="+name+"----pass="+pass;
    }

    @RequestMapping("/test01")
    public String configtest01(){

        return test.getName()+test.getPass();
    }
    @RequestMapping("/users/{pageNum}/{pageSize}")
    public Object getAllUser(@PathVariable int pageNum, @PathVariable int pageSize) {
        List<SysUser> lists=sysUserService.findAllByPage(pageNum, pageSize);
        return lists;
    }

    @RequestMapping("/users2/{pageNum}/{pageSize}")
    public Object getAllUser2(@PathVariable int pageNum, @PathVariable int pageSize) {
        PageInfo<SysUser> pageInfo=sysUserService.findAllByPage2(pageNum, pageSize);
        return pageInfo;
    }

}

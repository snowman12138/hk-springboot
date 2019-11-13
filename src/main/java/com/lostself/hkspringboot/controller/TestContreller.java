package com.lostself.hkspringboot.controller;

import com.lostself.hkspringboot.entity.SysUser;
import com.lostself.hkspringboot.service.ISysUserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContreller {

    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping("/find")
    public SysUser getUser(){
        return sysUserService.findById(1l);
    }

}

package com.lostself.hkspringboot.controller;

import com.lostself.hkspringboot.entity.SysUser;
import com.lostself.hkspringboot.service.imp.SysUserServiceCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class IndexController {

    private final static Logger log = org.slf4j.LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private SysUserServiceCache sysUserServiceCache;

    @RequestMapping("/select/{id}")
    public Object findUser(@PathVariable Integer id){

        HashMap<String, Object> map = new HashMap<>();
        SysUser sysUser = sysUserServiceCache.fingByPrimarykey(id);
        log.info("查询了id为：{}的用户的信息",sysUser.getId());
        SysUser sysUser1 = sysUserServiceCache.fingByPrimarykey(sysUser.getId());
        log.info("查询了id为：{}的用户的信息",sysUser1.getId());
        map.put("res",sysUser);
        return map;
    }

    @RequestMapping("/update")
    public Object update(){
        HashMap<String, Object> map = new HashMap<>();
        //第一次进行修改
        SysUser sysUser = new SysUser(6,"snowman","snowsheep","12138","ri","0");
        sysUserServiceCache.updateSysuser(sysUser);
        //第一次查询
        sysUserServiceCache.fingByPrimarykey(6);
        log.info("查询了id为:{}的用户的信息",sysUser.getId());
        //第二次修改
        SysUser sysUser2 = new SysUser(6,"snowman","snowsheep2","12138","ri","0");
        sysUserServiceCache.updateSysuser(sysUser2);
        //第二次查询
        SysUser sysUser1 = sysUserServiceCache.fingByPrimarykey(6);
        log.info("查询了id为:{}的用户的信息",sysUser1.getId());
        map.put("res",sysUser1);
        return map;
    }

    @RequestMapping("/insert")
    public Object insert (){

        HashMap<String, Object> map = new HashMap<>();
        SysUser sysUser = new SysUser();
        sysUser.setId(9);
        sysUser.setUsername("snowe");
        sysUser.setLocked("1");
        sysUser.setPassword("123");
        sysUser.setUsercode("24y");
        sysUser.setSalt("2dsfsf");
        sysUserServiceCache.insertSysuser(sysUser);
        SysUser sysUser1 = sysUserServiceCache.fingByPrimarykey(sysUser.getId());
        map.put("res",sysUser1);
        return map;
    }
    @RequestMapping("/delete/{id}")
    public Object delete(@PathVariable Integer id){

        HashMap<String, Object> map = new HashMap<>();
        sysUserServiceCache.deleteByPrimarykey(id);
        SysUser sysUser = sysUserServiceCache.fingByPrimarykey(id);
        map.put("sys",sysUser);
        return map;
    }

}

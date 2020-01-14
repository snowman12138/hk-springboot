package com.lostself.hkspringboot.controller;

import com.lostself.hkspringboot.config.Log;
import com.lostself.hkspringboot.service.ISysLogService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.util.HashMap;

@Controller
public class LogController {

    private final static Logger log = org.slf4j.LoggerFactory.getLogger(LogController.class);

    @Autowired
    private ISysLogService logService;

    @RequestMapping("/aop")
    @ResponseBody
    @Log("测试aop LOG")
    public Object aop(String name,String nick){

        HashMap<String, Object> map = new HashMap<>();
        log.info("我被执行了！");
        map.put("res","ok");
        return map;
    }

    @RequestMapping("/testaop3")
    @ResponseBody
    public Object testAop3(String name,String nick){

        HashMap<String, Object> map = new HashMap<>();
        map.put("res","ok");
        return map;
    }
}

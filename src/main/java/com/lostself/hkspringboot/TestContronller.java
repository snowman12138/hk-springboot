package com.lostself.hkspringboot;

import com.sun.javafx.scene.control.behavior.TextBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class TestContronller {
    @Autowired
    private Test test;

    @Value("${blog.login.name}")
    private String name;

    @Value("${blog.login.pass}")
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
}

package com.lostself.hkspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("com.lostself.hkspringboot.dao")
public class HkSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HkSpringbootApplication.class, args);
    }

}

package com.lostself.hkspringboot.controller;

import java.lang.annotation.*;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
@Documented
public @interface ann {

        String name(); // 因为没有定义public，所以默认的访问权限为包权限，在定义时没有指定默认值，则使用时必须指定默认值
        String group();

}

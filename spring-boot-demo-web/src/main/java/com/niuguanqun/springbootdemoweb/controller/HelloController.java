package com.niuguanqun.springbootdemoweb.controller;

import com.niuguanqun.springbootdemoweb.util.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * @restController注解
 * 默认类中的方法都会以 json 的格式返回
 */
@RestController
public class HelloController {

    @Autowired
    private MyProperties myProperties;

    @RequestMapping("/hello")
    public String hello(Locale locale, Model model) {

        System.err.println(myProperties);
        return "Hello World";

    }

}
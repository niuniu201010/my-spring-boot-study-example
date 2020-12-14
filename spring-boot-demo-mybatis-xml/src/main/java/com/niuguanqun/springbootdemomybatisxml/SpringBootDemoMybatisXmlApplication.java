package com.niuguanqun.springbootdemomybatisxml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.niuguanqun.springbootdemomybatisxml.mapper")
public class SpringBootDemoMybatisXmlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoMybatisXmlApplication.class, args);
    }

}

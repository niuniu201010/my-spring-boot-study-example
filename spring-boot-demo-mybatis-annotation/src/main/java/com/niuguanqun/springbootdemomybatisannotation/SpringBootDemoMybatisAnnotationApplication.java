package com.niuguanqun.springbootdemomybatisannotation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.niuguanqun.springbootdemomybatisannotation.mapper")
public class SpringBootDemoMybatisAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoMybatisAnnotationApplication.class, args);
    }

}

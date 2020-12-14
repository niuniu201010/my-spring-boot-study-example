package com.niuguanqun.springbootdemomybatisannotationmulidatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.niuguanqun.springbootdemomybatisannotationmulidatasource.mapper.db1")
@MapperScan("com.niuguanqun.springbootdemomybatisannotationmulidatasource.mapper.db2")
public class SpringBootDemoMybatisAnnotationMulidatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoMybatisAnnotationMulidatasourceApplication.class, args);
    }

}

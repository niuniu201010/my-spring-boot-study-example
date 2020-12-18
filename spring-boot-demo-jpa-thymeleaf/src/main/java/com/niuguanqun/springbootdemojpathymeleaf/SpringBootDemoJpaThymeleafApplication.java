package com.niuguanqun.springbootdemojpathymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootDemoJpaThymeleafApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootDemoJpaThymeleafApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoJpaThymeleafApplication.class, args);
    }

}

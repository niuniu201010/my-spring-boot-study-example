package com.niuguanqun.springgbootdemoscheduler;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling//开启定时
public class SpringgBootDemoSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringgBootDemoSchedulerApplication.class, args);
    }

}

package com.tongxue.wxapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class WxappApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxappApplication.class, args);
    }

    /*@Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager){
        *//*System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());*//*
        return new Object();
    }*/

}

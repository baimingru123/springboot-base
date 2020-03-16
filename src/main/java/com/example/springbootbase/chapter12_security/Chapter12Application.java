package com.example.springbootbase.chapter12_security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author bmr
 * @time 2020-02-27 15:50
 */
@SpringBootApplication
//@MapperScan("com.example.springbootbase.chapter11_rest.dao")
public class Chapter12Application {
    public static void main(String[] args) {
        SpringApplication.run(Chapter12Application.class,args);
    }



}

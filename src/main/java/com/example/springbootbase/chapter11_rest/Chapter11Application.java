package com.example.springbootbase.chapter11_rest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author bmr
 * @time 2020-02-27 15:50
 */
@SpringBootApplication
@MapperScan("com.example.springbootbase.chapter11_rest.dao")
public class Chapter11Application {
    public static void main(String[] args) {
        SpringApplication.run(Chapter11Application.class,args);
    }



}

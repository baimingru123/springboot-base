package com.example.springbootbase.chapter10_mvc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

/**
 * @author bmr
 * @time 2020-02-27 15:50
 */
@SpringBootApplication
@MapperScan("com.example.springbootbase.chapter10_mvc.dao")
public class Chapter10Application {
    public static void main(String[] args) {
        SpringApplication.run(Chapter10Application.class,args);
    }



}

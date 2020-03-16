package com.example.springbootbase.chapter15;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @author bmr
 * @time 2020-03-05 9:49
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan("com.example.springbootbase.chapter15.dao")
public class Chapter15Application {
    public static void main(String[] args) {
        SpringApplication.run(Chapter15Application.class,args);
    }
}

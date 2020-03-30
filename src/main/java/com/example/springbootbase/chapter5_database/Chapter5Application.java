package com.example.springbootbase.chapter5_database;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author bmr
 * @time 2020-01-09 11:41
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@MapperScan(basePackages = "com.example.springbootbase.chapter5_database.dao",annotationClass = Mapper.class)
public class Chapter5Application {
    public static void main(String[] args) {
        SpringApplication.run(Chapter5Application.class,args);
    }
}

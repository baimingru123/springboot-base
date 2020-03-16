package com.example.springbootbase.chapter6_transaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;

/**
 * @author bmr
 * @time 2020-01-09 11:41
 */
@SpringBootApplication()
@MapperScan("com.example.springbootbase.chapter6_transaction.dao")
public class Chapter6Application {
    public static void main(String[] args) {
        SpringApplication.run(Chapter6Application.class,args);
    }

    //注入事务管理器，它由spring boot自动生成
    @Autowired
    PlatformTransactionManager transactionManager=null;

    //使用后初始化方法，观察自动生成的事务管理器
    @PostConstruct
    public void viewTransactionManager(){
        //启动前加入断点观测
        System.out.println(transactionManager.getClass().getName());
    }

}




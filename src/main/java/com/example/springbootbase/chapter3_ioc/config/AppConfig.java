package com.example.springbootbase.chapter3_ioc.config;

import com.example.springbootbase.chapter3_ioc.pojo.User;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Properties;


/**
 * @author bmr
 * @time 2019-12-30 15:04
 */
@Configuration
@ComponentScan(basePackages = "com.example.springbootbase.chapter3_ioc.*",
        excludeFilters = {@ComponentScan.Filter(classes = {Service.class})},
        lazyInit = false)
@ImportResource(value = "classpath:spring-other.xml")
@PropertySource(value = "classpath:application.properties")
public class AppConfig {

//    @Bean(name = "user")
//    public User initUser(){
//        User user=new User();
//        user.setId(1L);
//        user.setUserName("user_name_1");
//        user.setNote("note_1");
//        return user;
//    }


}

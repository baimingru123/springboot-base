package com.example.springbootbase.chapter3_ioc.test;

import com.example.springbootbase.chapter3_ioc.config.AppConfig;
import com.example.springbootbase.chapter3_ioc.interfaces.Person;
import com.example.springbootbase.chapter3_ioc.pojo.DataBaseProperties;
import com.example.springbootbase.chapter3_ioc.pojo.User;
import com.example.springbootbase.chapter3_ioc.service.UserService;
import com.example.springbootbase.other.pojo.Squirrel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author bmr
 * @time 2019-12-30 15:07
 */
public class IoCTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);

        DataBaseProperties dataBaseProperties=ctx.getBean("dataBaseProperties",DataBaseProperties.class);
        System.out.println(dataBaseProperties);

        Squirrel squirrel=ctx.getBean("squirrel",Squirrel.class);
        squirrel.use();
//        ctx.close();
//        Stream.of(ctx.getBeanDefinitionNames()).collect(Collectors.toList()).forEach(System.out::println);
//        User user=ctx.getBean(User.class);
//        System.out.println(user);
//
//        Person person=ctx.getBean(Person.class);
//        person.service();
//        UserService userService=ctx.getBean(UserService.class);
//        userService.printUser();
    }
}

package com.example.springbootbase.chapter4_aop;

import com.example.springbootbase.chapter4_aop.intercept.MyInterceptor;
import com.example.springbootbase.chapter4_aop.proxy.ProxyBean;
import com.example.springbootbase.chapter4_aop.service.HelloService;
import com.example.springbootbase.chapter4_aop.service.impl.HelloServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author bmr
 * @time 2020-01-08 15:21
 */
@SpringBootApplication()
public class AopTest {

    public static void main(String[] args) {
        SpringApplication.run(AopTest.class,args);
    }


    public static void testProxy(String[] args) {
        HelloService helloService=new HelloServiceImpl();
        HelloService proxy=(HelloService) ProxyBean.getProxyBean(helloService,new MyInterceptor());
        proxy.sayHello("xb");
        System.out.println("### name is  null  ##");
        proxy.sayHello(null);
    }
}

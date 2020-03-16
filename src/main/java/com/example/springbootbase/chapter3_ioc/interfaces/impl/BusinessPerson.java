package com.example.springbootbase.chapter3_ioc.interfaces.impl;

import com.example.springbootbase.chapter3_ioc.interfaces.Animal;
import com.example.springbootbase.chapter3_ioc.interfaces.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author bmr
 * @time 2019-12-30 16:28
 */
//@Component
public class BusinessPerson implements Person, BeanNameAware, BeanFactoryAware,
        ApplicationContextAware, InitializingBean, DisposableBean {


    private Animal animal;

    @Override
    public void service() {
        this.animal.use();
    }

//    @Override
    @Autowired
    @Qualifier("dog")
    public void setAnimal(Animal animal) {
        System.out.println("延迟依赖注入");
        this.animal=animal;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println(this.getClass().getSimpleName()+"调用BeanNameAware的setBeanName方法");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(this.getClass().getSimpleName()+"调用BeanFactoryAware的setBeanFactory方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(this.getClass().getSimpleName()+"调用ApplicationContextAware的setApplicationContext方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getSimpleName()+"调用InitializingBean的afterPropertiesSet方法");
    }

    @PostConstruct
    public void init(){
        System.out.println(this.getClass().getSimpleName()+"注解@PostConstruce定义的初始化方法");
    }

    @PreDestroy
    public void destroy1(){
        System.out.println(this.getClass().getSimpleName()+"调用@PreDestory定义的自定义销毁方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass().getSimpleName()+"调用DisposableBean方法");
    }




}

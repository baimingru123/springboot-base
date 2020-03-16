package com.example.springbootbase.chapter3_ioc.interfaces.impl;

import com.example.springbootbase.chapter3_ioc.interfaces.Animal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author bmr
 * @time 2019-12-30 16:38
 */
@Component
@Primary
public class Cat implements Animal {
    @Override
    public void use() {
        System.out.println(Cat.class.getSimpleName()+"是用来抓老鼠的");
    }
}

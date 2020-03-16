package com.example.springbootbase.chapter3_ioc.interfaces.impl;

import com.example.springbootbase.chapter3_ioc.interfaces.Animal;
import org.springframework.stereotype.Component;

/**
 * @author bmr
 * @time 2019-12-30 16:26
 */
@Component
public class Dog implements Animal {

    @Override
    public void use() {
        System.out.println(Dog.class.getSimpleName()+"是用来看门的");
    }
}

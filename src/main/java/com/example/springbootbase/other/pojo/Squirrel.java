package com.example.springbootbase.other.pojo;

import com.example.springbootbase.chapter3_ioc.interfaces.Animal;

/**
 * @author bmr
 * @time 2020-01-08 11:57
 */
public class Squirrel implements Animal {

    @Override
    public void use() {
        System.out.println("松鼠可以采集松果");
    }
}

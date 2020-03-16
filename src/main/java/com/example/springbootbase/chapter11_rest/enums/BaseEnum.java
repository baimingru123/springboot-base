package com.example.springbootbase.chapter11_rest.enums;

/**
 * @author bmr
 * @time 2020-03-02 10:18
 */
public interface BaseEnum<E extends Enum<?>,T> {
    public T getCode();
    public String getName();
}

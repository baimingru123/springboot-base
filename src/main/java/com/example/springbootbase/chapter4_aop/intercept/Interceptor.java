package com.example.springbootbase.chapter4_aop.intercept;

import com.example.springbootbase.chapter4_aop.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @author bmr
 * @time 2020-01-08 14:26
 */
public interface Interceptor {

    //事前方法
    boolean before();

    //事后方法
    void after();

    /**
     * 取代原有事件方法
     * @param invocation  --回调参数  可以通过它的proceed方法，回调原有事件
     * @return  原有事件返回对象
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    Object around(Invocation invocation) throws InvocationTargetException,IllegalAccessException;

    //事后返回方法，当事件没有发生异常执行
    void afterReturning();

    //事后异常方法，当事件发生异常后执行
    void afterThrowing();

    //是否使用around方法取代原有方法
    boolean useAround();

}

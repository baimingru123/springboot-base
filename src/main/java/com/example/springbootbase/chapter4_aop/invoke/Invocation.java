package com.example.springbootbase.chapter4_aop.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author bmr
 * @time 2020-01-08 14:29
 */
public class Invocation {

    //方法参数列表
    private Object[] params;
    //要执行的方法
    private Method method;
    //目标对象
    private Object target;

    public Invocation(Object[] params, Method method, Object target) {
        this.params = params;
        this.method = method;
        this.target = target;
    }

    //反射方法
    public Object proceed() throws InvocationTargetException,IllegalAccessException{
        return method.invoke(target,params);
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}

package com.example.springbootbase.chapter4_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author bmr
 * @time 2020-01-08 16:26
 */
@Aspect
@Component
@Order(3)
public class MyAspect3 {


    //定义切点
    @Pointcut("execution(* com.example.springbootbase.chapter4_aop.service.impl.UserServiceImpl.manyAspects(..))")
    public void pointCut(){

    }
    @Before("pointCut() ")
    public void before(JoinPoint joinPoint){
        Object[] args=joinPoint.getArgs();
//        System.out.println("before user:"+user);
//        System.out.println("MyAspect3 before 中的参数列表:"+ Arrays.toString(args));
        System.out.println("MyAspect3 before ...");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("MyAspect3 around before ...");
        //调用目标对象的原有方法
        jp.proceed();
        System.out.println("MyAspect3 around after ...");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("MyAspect3 after ...");
    }


    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("MyAspect3 afterReturning ...");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("MyAspect3 afterThrowing ...");
    }

}

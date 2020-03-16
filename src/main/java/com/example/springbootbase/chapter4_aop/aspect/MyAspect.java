package com.example.springbootbase.chapter4_aop.aspect;

import com.example.springbootbase.chapter3_ioc.pojo.User;
import com.example.springbootbase.chapter4_aop.service.impl.UserServiceImpl;
import com.example.springbootbase.chapter4_aop.validator.UserValidator;
import com.example.springbootbase.chapter4_aop.validator.impl.UserValidatorImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author bmr
 * @time 2020-01-08 16:26
 */
@Aspect
@Component
public class MyAspect {


    @DeclareParents(
            value = "com.example.springbootbase.chapter4_aop.service.impl.UserServiceImpl+",
            defaultImpl = UserValidatorImpl.class
    )
    public UserValidator userValidator;

    //定义切点
    @Pointcut("execution(* com.example.springbootbase.chapter4_aop.service.impl.UserServiceImpl.printUser(..))")
    public void pointCut(){

    }
    @Before("pointCut() ")
    public void before(JoinPoint joinPoint){
        Object[] args=joinPoint.getArgs();
//        System.out.println("before user:"+user);
        System.out.println("before 中的参数列表:"+ Arrays.toString(args));
        System.out.println("before ...");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around before ...");
        //调用目标对象的原有方法
        jp.proceed();
        System.out.println("around after ...");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("after ...");
    }


    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("afterReturning ...");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("afterThrowing ...");
    }

}

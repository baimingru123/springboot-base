package com.example.springbootbase.chapter10_mvc.config;

import com.example.springbootbase.chapter10_mvc.interceptor.Interceptor1;
import com.example.springbootbase.chapter10_mvc.interceptor.MultiInterceptor1;
import com.example.springbootbase.chapter10_mvc.interceptor.MultiInterceptor2;
import com.example.springbootbase.chapter10_mvc.interceptor.MultiInterceptor3;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author bmr
 * @time 2020-02-28 16:35
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //注册拦截器到spring mvc机制，然后他会返回一个拦截器注册
        InterceptorRegistration ir1=registry.addInterceptor(new MultiInterceptor1());
        //指定拦截匹配模式，限定拦截器拦截请求
        ir1.addPathPatterns("/interceptor/*");

        InterceptorRegistration ir2=registry.addInterceptor(new MultiInterceptor2());
        ir2.addPathPatterns("/interceptor/*");

        InterceptorRegistration ir3=registry.addInterceptor(new MultiInterceptor3());
        ir3.addPathPatterns("/interceptor/*");
    }
}

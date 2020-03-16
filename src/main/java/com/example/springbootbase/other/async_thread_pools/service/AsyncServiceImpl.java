package com.example.springbootbase.other.async_thread_pools.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author bmr
 * @time 2020-03-03 17:16
 */
@Service
public class AsyncServiceImpl implements AsyncService {
    @Override
    @Async
    public void generateReport() {
        //打印异步线程名称
        System.out.println("报表线程名称："+"【"+Thread.currentThread().getName()+"】");
    }
}

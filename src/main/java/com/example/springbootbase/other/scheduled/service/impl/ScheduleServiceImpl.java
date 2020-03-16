package com.example.springbootbase.other.scheduled.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author bmr
 * @time 2020-03-04 14:51
 */
@Service
public class ScheduleServiceImpl {

    //计数器
    int count1=1;
    int count2=1;

    //每隔一秒执行一次
    @Scheduled(initialDelay = 3000,fixedRate = 1000)
    //使用异步执行
    @Async
    public void job1(){
        System.out.println(Thread.currentThread().getName()+"【job1】每秒钟执行一次，执行第"+count1+"次");
        count1++;
    }

    //每隔一秒执行一次
    @Scheduled(fixedRate = 1000)
    //使用异步执行
    @Async
    public void job2(){
        System.out.println(Thread.currentThread().getName()+"【job2】每秒钟执行一次，执行第"+count2+"次");
        count2++;
    }
}

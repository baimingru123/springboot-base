package com.example.springbootbase.chapter7_redis;

import com.example.springbootbase.chapter7_redis.config.RedisConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author bmr
 * @time 2020-02-25 10:26
 */
public class Chapter7Main {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(RedisConfig.class);
        RedisTemplate redisTemplate=ctx.getBean(RedisTemplate.class);
        redisTemplate.opsForValue().set("key1","value1");
        redisTemplate.opsForHash().put("hash","field","hvalue");

    }
}

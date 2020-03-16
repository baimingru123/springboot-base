package com.example.springbootbase.chapter7_redis.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author bmr
 * @time 2020-02-26 9:06
 */
@Component
public class RedisMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        //消息体
        String body=new String(message.getBody());
        //渠道名称
        String topic=new String(pattern);
        System.out.println("消息内容："+body);
        System.out.println("渠道名称："+topic);
    }
}

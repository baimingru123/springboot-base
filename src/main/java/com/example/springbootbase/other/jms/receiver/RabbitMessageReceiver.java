package com.example.springbootbase.other.jms.receiver;

import com.example.springbootbase.other.jms.pojo.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author bmr
 * @time 2020-03-04 10:49
 */
@Component
public class RabbitMessageReceiver {

    //定义监听字符串队列名称
    @RabbitListener(queues ="${rabbitmq.queue.msg}")
    public void receiveMsg(String msg){
        System.out.println("收到消息："+msg);
    }

    //定义监听用户队列名称
    @RabbitListener(queues = "${rabbitmq.queue.user}")
    public void receiveUser(User user){
        System.out.println("收到的用户信息："+user);
    }
}

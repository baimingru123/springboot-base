package com.example.springbootbase.chapter7_redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;
import java.time.Duration;

/**
 * @author bmr
 * @time 2020-01-09 11:41
 */
@SpringBootApplication()
@MapperScan("com.example.springbootbase.chapter7_redis.dao")
@EnableCaching
public class Chapter7Application {
    @Autowired
    private RedisTemplate redisTemplate;

    //redis连接工厂
    @Autowired
    private RedisConnectionFactory connectionFactory;

    //redis消息监听器
    @Autowired
    private MessageListener redisMsgListener;

    //任务池
    private ThreadPoolTaskScheduler taskScheduler;



    //创建任务池，运行线程等待处理redis的消息
    @Bean
    public ThreadPoolTaskScheduler initTaskScheduler(){
        if(taskScheduler != null){
            return taskScheduler;
        }

        taskScheduler=new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(20);
        return taskScheduler;
    }

    //定义redis的监听容器
    @Bean
    public RedisMessageListenerContainer initRedisContainer(){
        RedisMessageListenerContainer container=new RedisMessageListenerContainer();
        //redis连接工厂
        container.setConnectionFactory(connectionFactory);
        //设置运行任务池
        container.setTaskExecutor(initTaskScheduler());
        //定义监听渠道，名称为topic1
        Topic topic=new ChannelTopic("topic1");
        //使用监听器监听redis的消息
        container.addMessageListener(redisMsgListener,topic);
        return container;
    }
    //定义自定义后初始化方法
    @PostConstruct
    public void init(){
        initRedisTemplate();
    }

    //设置RedisTemplate的序列器
    private void initRedisTemplate(){
        RedisSerializer stringSerializer= redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
    }

    //自定义redis缓存管理器
    @Bean("redisCacheManager")
    public RedisCacheManager initRedisCacheManager(){
        //redis加锁的写入器
        RedisCacheWriter writer=RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
        //启动redis缓存的默认设置
        RedisCacheConfiguration config=RedisCacheConfiguration.defaultCacheConfig();
        //设置jdk序列化器
        config=config.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new JdkSerializationRedisSerializer()));

        //禁用前缀
        config=config.disableKeyPrefix();
        //设置10min超时
        config=config.entryTtl(Duration.ofMinutes(2));
        //创建redis缓存管理器
        RedisCacheManager redisCacheManager=new RedisCacheManager(writer,config);
        return redisCacheManager;
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter7Application.class,args);
    }
}




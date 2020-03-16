package com.example.springbootbase.chapter3_ioc.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

/**
 * @author bmr
 * @time 2020-01-08 11:13
 */
@Component
public class DatabaseConditional implements Condition {

    /**
     * 数据库装配条件
     * @param conditionContext  条件上下文
     * @param annotatedTypeMetadata  注释类型的元数据
     * @return true 装配bean  否则不装配
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //取出环境配置
        Environment env=conditionContext.getEnvironment();
        //判断属性文件是否存在对应的数据库配置
        return env.containsProperty("database.driverName")
                && env.containsProperty("database.url")
                && env.containsProperty("database.username")
                && env.containsProperty("database.password");
    }
}

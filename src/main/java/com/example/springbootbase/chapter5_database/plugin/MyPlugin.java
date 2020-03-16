package com.example.springbootbase.chapter5_database.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.lang.annotation.Target;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author bmr
 * @time 2020-01-09 15:54
 */
//定义拦截签名
@Intercepts({
            @Signature(type = StatementHandler.class,
                    method = "prepare",
                    args = {Connection.class,Integer.class}
                )
})
public class MyPlugin implements Interceptor {

    Properties properties=null;


    //拦截方法逻辑
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("插件拦截方法");
        return invocation.proceed();
    }

    //生成MyBatis拦截器代理对象
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    //设置插件属性
    @Override
    public void setProperties(Properties properties) {
        this.properties=properties;
    }
}

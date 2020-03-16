package com.example.springbootbase.chapter3_ioc.config;

import com.example.springbootbase.chapter3_ioc.condition.DatabaseConditional;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author bmr
 * @time 2020-01-08 11:18
 */
@Configuration
public class DataBaseConfig {

    //获取数据源
    @Bean(name = "dataSource")
//    @Conditional(DatabaseConditional.class)
    public DataSource getDataSource(@Value("${database.driverName}") String driver,
                                    @Value("${database.url}") String url,
                                    @Value("${database.username}")String username,
                                    @Value("${database.password}")String password)  {
        Properties properties=new Properties();
        properties.setProperty("driver",driver);
        properties.setProperty("url",url);
        properties.setProperty("username",username);
        properties.setProperty("driver",password);

        DataSource dataSource=null;
        try {
            dataSource= BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataSource;
    }
}

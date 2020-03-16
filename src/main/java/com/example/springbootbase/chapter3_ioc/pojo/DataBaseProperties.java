package com.example.springbootbase.chapter3_ioc.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author bmr
 * @time 2020-01-08 9:33
 */
@Component
//@ConfigurationProperties("database")
public class DataBaseProperties {

    @Value("${database.driverName}")
    private String driverName=null;

    @Value("${database.url}")
    private String url=null;

    @Value("${database.username}")
    private String username=null;

    @Value("${database.password}")
    private String password=null;


    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        System.out.println("driverName:"+driverName);
        this.driverName = driverName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        System.out.println(url);
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println(username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println(password);
        this.password = password;
    }

    @Override
    public String toString() {
        return "DataBaseProperties{" +
                "driverName='" + driverName + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

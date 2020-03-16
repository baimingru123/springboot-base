package com.example.springbootbase.other.scheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author bmr
 * @time 2020-03-04 15:03
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//@EnableScheduling
public class ScheduledApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScheduledApplication.class,args);
    }
}

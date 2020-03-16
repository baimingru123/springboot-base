package com.example.springbootbase.chapter3_ioc.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author bmr
 * @time 2019-12-30 15:03
 */
@Data
@Component
public class User {
    @Value("2")
    private Long id;
    @Value("user_name_2")
    private String userName;
    @Value("note_2")
    private String note ;
}

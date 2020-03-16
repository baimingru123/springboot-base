package com.example.springbootbase.chapter10_mvc.config;

import com.example.springbootbase.chapter10_mvc.pojo.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author bmr
 * @time 2020-02-27 15:53
 */
@Component
public class StringToUserConvert implements Converter<String, User> {

    @Override
    public User convert(String s) {
        String[] strArr=s.split("-");
        User user=new User();
        user.setUserName(strArr[0]);
        user.setNote(strArr[1]);
        return user;
    }
}

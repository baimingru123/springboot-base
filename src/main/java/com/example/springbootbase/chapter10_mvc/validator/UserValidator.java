package com.example.springbootbase.chapter10_mvc.validator;

import com.example.springbootbase.chapter10_mvc.pojo.User;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author bmr
 * @time 2020-02-28 9:06
 */
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        //对象为空
        if(o == null){
            //直接在参数处报错，这样就不能进入控制器的方法
            errors.rejectValue("",null,"用户不能为空");
        }

        //强制转换
        User user=(User)o;

        //用户名非空串
        if(StringUtils.isEmpty(user.getUserName())){
            errors.rejectValue("userName",null,"用户名不能为空");
        }

    }
}

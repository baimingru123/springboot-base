package com.example.springbootbase.chapter12_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author bmr
 * @time 2020-03-03 12:00
 */
@Component
public class CustomerWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${system.user.password.secret}")
    private String secret;

    @Autowired
    private UserDetailsService userDetailsService;

    //使用内存缓存用户信息   开发和测试阶段可以用
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //密码编码器
//        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
//        //使用内部存储
//        auth.inMemoryAuthentication()
//                //设置密码编码器
//            .passwordEncoder(passwordEncoder)
//                //注册用户admin,密码为abc,并赋予USER和ADMIN的角色权限
//            .withUser("admin")
//                //可通过passwordEncoder.encode("abc")得到加密后的密码
//            .password(passwordEncoder.encode("abc"))
//            . roles("USER","ADMIN")
//            //连接方法and
//             .and()
//            //注册用户myuser，密码为123456，并赋予USER角色权限
//            .withUser("myuser")
//            .password(passwordEncoder.encode("123456"))
//            .roles("USER");
//
//
//    }

    //使用数据库定义用户认证服务
//    @Autowired
//    private DataSource dataSource;
//
//    //使用用户名称查询密码
//    String pwdQuery="select user_name,pwd,available from t_user where user_name=?";
//    //使用用户名称查询角色信息
//    String roleQuery="select u.user_name,r.role_name from t_user u,t_user_role ur,t_role r where u.id=ur.user_id and r.id=ur.role_id and u.user_name=?";
//
//    /**
//     * 覆盖WebSecurityConfigurerAdpater用户详情方法
//     * @param auth 用户签名管理器构造器
//     * @throws Exception
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //密码编码器
//        PasswordEncoder passwordEncoder=new Pbkdf2PasswordEncoder(this.secret);
//        auth.jdbcAuthentication().passwordEncoder(passwordEncoder)
//                //数据源
//                .dataSource(dataSource)
//                //查询用户，自动判断密码是否一致
//                .usersByUsernameQuery(pwdQuery)
//                //赋予权限
//                .authoritiesByUsernameQuery(roleQuery);
//    }


    //使用自定义用户认证服务
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder=new Pbkdf2PasswordEncoder(this.secret);
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    //请求限定
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //使用spring表达式限定只有角色ROLE_USER和ROLE_ADMIN
                .antMatchers("/user/**").access("hasRole('USER') or hasRole('ADMIN')")
                //设置访问权限给角色ROLE_ADMIN,要求是完整登录(非记住我登录)
                .antMatchers("/admin/welcome1").access("hasAuthority('ROLE_ADMIN') && isFullyAuthenticated()")
                //限定"/admin/welcome2"访问权限给角色ROLE_ADMIN,允许不完整登录
                .antMatchers("/admin/welcome2").access("hasAuthority('ROLE_ADMIN')")
                //使用记住我功能
                .and().rememberMe()
                //使用spring security默认的登录页面
                .and().formLogin()
                //启用http基础验证
                .and().httpBasic();
    }
}

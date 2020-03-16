package com.example.springbootbase.chapter11_rest.restTemplate;

import com.example.springbootbase.chapter11_rest.pojo.User;
import com.example.springbootbase.chapter11_rest.vo.UserVo;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bmr
 * @time 2020-03-03 9:32
 */
public class TestRestTemplate {

    public static void main(String[] args) {
//        getUser(1L);
//        findUser("xx","xx",0,3);
        UserVo userVo=new UserVo();
        userVo.setUserName("rest_user_name3");
        userVo.setSexCode(2);
        userVo.setNote("rest_note3");
//        insertUser(userVo);
        insertUserEntity(userVo);

    }

    public static UserVo getUser(Long id){
        RestTemplate restTemplate=new RestTemplate();
        UserVo userVo=restTemplate.getForObject("http://localhost:8080/user/{id}",UserVo.class,id);
        System.out.println(userVo);
        return userVo;
    }

    public static List<UserVo> findUser(String userName,String note,int start,int limit){
        RestTemplate restTemplate=new RestTemplate();
        Map<String,Object> params=new HashMap<>();
        params.put("userName",userName);
        params.put("note",note);
        params.put("start",start);
        params.put("limit",limit);
        String url="http://localhost:8080/users/{userName}/{note}/{start}/{limit}";
        ResponseEntity<List> responseEntity=restTemplate.getForEntity(url,List.class,params);
        List<UserVo> userVoList=responseEntity.getBody();
        System.out.println(userVoList);
        return userVoList;
    }

    public static User insertUser(UserVo newUserVo){
        HttpHeaders headers=new HttpHeaders();
        //设置请求内容为json类型
        headers.setContentType(MediaType.APPLICATION_JSON);
        //创建请求实体对象
        HttpEntity<UserVo> request=new HttpEntity<>(newUserVo,headers);
        RestTemplate restTemplate=new RestTemplate();
        User user=restTemplate.postForObject("http://localhost:8080/user",request,User.class);
        System.out.println(user);
        return user;
    }

    public static User insertUserEntity(UserVo newUserVo){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserVo> request=new HttpEntity<>(newUserVo,httpHeaders);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<User> userEntity=restTemplate.postForEntity("http://localhost:8080/user2/entity",request,User.class);

        //获取响应体
        User user=userEntity.getBody();
        //获取响应头
        HttpHeaders respHeaders=userEntity.getHeaders();
        //获取响应属性
        List<String> success=respHeaders.get("success");
        System.out.println("success:"+success);
        //响应的http状态码
        int status=userEntity.getStatusCodeValue();
        System.out.println("status:"+status);
        System.out.println(user);
        return user;
    }
}

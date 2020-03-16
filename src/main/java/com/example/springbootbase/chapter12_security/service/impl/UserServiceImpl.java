package com.example.springbootbase.chapter12_security.service.impl;

import com.example.springbootbase.chapter12_security.dao.UserDao;
import com.example.springbootbase.chapter12_security.pojo.User;
import com.example.springbootbase.chapter12_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author bmr
 * @time 2020-01-10 9:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    @Cacheable(value = "redisCache",key =" 'redis_user_'+#result.id" )
    public User insertUser(User user) {
        return userDao.insertUser(user)==0?null:user;
    }

    @Override
    @Transactional
    @Cacheable(value = "redisCache:userCache",key = " 'redis_user_'+#id")
    public User getUser(Long id) {
        return userDao.getUser(id);
    }



    //更新数据后，更新缓存。如果condition配置项使结果返回null，不缓存
    @Override
    @Transactional
    @CachePut(value = "redisCache",condition = "#result != 'null'",key = "'redis_user_'+#id")
    public User updateUserName(Long id, String userName) {
        //此处调用getUser方法，该方法缓存注解失效，所以这里还会执行sql，将查询到数据库最新数据
        User user=this.getUser(id);
        if(user == null){
            return null;
        }
        user.setUserName(userName);
        userDao.updateUser(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        int flag=userDao.updateUser(user);
        if(flag==1){
            return user;
        }else{
            return null;
        }

    }

    //命中率低，所以不采用缓存机制
    @Override
    @Transactional
    public List<User> findUsers(String userName, String note) {
        return userDao.findUsers(userName,note);
    }

    @Override
    public List<User> findUsers(String userName, String note, int start, int limit) {
        return userDao.findUsersLimit(userName,note,start,limit);
    }

    @Override
    @Transactional
    @CacheEvict(value = "redisCache",key = "'redis_user_'+#id")
    public int deleteUser(Long id) {
        return userDao.deleteUser(id);
    }
}

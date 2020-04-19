package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: demo
 * @description:
 * @author: Mr.Qin
 * @create: 2019-12-09 17:04
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    //用户登录
    public User userLogin(String email,String password){
        User user=userMapper.userLogin(email);
        return user;
    }

    //注册用户
    public int addUser(String firstname,String lastname,String email,String password){

        User user=new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPassword(password);
        return userMapper.insert(user);
    }
}

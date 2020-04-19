package com.example.demo.controller;

import com.example.demo.dto.QQResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: demo
 * @description: 登陆注册
 * @author: Mr.Qin
 * @create: 2019-12-06 20:30
 **/
@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/signinpage")
    public String signinpage(){
        return "signin.html";
    }

    @RequestMapping("/signuppage")
    public String signuppage(){
        return "signup.html";
    }


    @RequestMapping("/login")
    @ResponseBody
    public Object Login(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request){

        User user=userService.userLogin(email,password);
        if(user!=null){
            System.out.println(user);
            if(user.getPassword().equals(password)){
                request.getSession().setAttribute("session_user",user);
                return QQResponse.ok();
            } else {
               return QQResponse.fail(2,"您的密码错误");
            }
        }
        return QQResponse.fail(1,"您未注册");

    }

    @RequestMapping(value = "/regist")
    public String addUser(@RequestParam("name1") String name1,
                          @RequestParam("name2") String name2,
                          @RequestParam("email") String email,
                          @RequestParam("password") String password){
        int res=userService.addUser(name1,name2,email,password);
        if(res == 0){
            return "signup.html";
        }else {
            return "signin.html";
        }
    }




}

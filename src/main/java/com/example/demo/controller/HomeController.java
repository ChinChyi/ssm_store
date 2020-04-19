package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: demo
 * @description: hoem
 * @author: Mr.Qin
 * @create: 2019-11-07 20:07
 **/
@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping
    public String index(){
        return "index";
    }

}

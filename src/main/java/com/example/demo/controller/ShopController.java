package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: demo
 * @description: 商店控制器
 * @author: Mr.Qin
 * @create: 2019-12-05 21:31
 **/

@Controller
@RequestMapping("/shop")
public class ShopController {

    @RequestMapping("/index")
    public String gotoIndex(){
        return "index.html";
    }

    @RequestMapping("/selfShop")
    public String gotoShop(){
        return "shop.html";
    }
    @RequestMapping("/product")
    public String gotoProduct(){
        return "product-details.html";
    }

}

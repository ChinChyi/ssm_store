package com.example.demo.controller;

import com.example.demo.entity.Usercart;
import com.example.demo.service.ProductService;
import com.example.demo.service.UsercartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: demo
 * @description: 商品控制器、
 * @author: Mr.Qin
 * @create: 2019-12-05 21:31
 **/
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    UsercartService usercartService;

    @RequestMapping("/index")
    public String gotoIndex(){
        return "index.html";
    }

    @RequestMapping("/selfProduct")
    public String gotoProduct(){
        return "product-details.html";
    }
    @RequestMapping("login")
    public String Login(){
        return "signin.html";
    }

    @ResponseBody
    @RequestMapping("/getProduct")
    public List<Usercart> getProduct(){
        List<Usercart> usercarts=usercartService.lodeProductCart();
        return usercarts;
    }

    @ResponseBody
    @RequestMapping("/deleteProduct")
    public int deleteProduct(Integer productId){
        return usercartService.deleteProduct(productId);
    }
}

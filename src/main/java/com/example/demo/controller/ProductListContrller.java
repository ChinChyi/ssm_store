package com.example.demo.controller;

import com.example.demo.dto.QQResponse;
import com.example.demo.entity.Product;
import com.example.demo.entity.Usercart;
import com.example.demo.service.ProductService;
import com.example.demo.service.UsercartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: demo
 * @description:
 * @author: Mr.Qin
 * @create: 2019-12-10 22:45
 **/
@Controller
public class ProductListContrller {


    @Autowired
    private UsercartService usercartService;

    @ResponseBody
    @RequestMapping("/addProduct")
    public Object addProduct(@RequestParam("productId") Integer productId,@RequestParam("productName") String productName,
                             @RequestParam("productPrice") Integer productPrice,@RequestParam("productSrc") String productSrc
                             ){
        System.out.println("productId="+productId+" productName="+productName+" productPrice="+productPrice+" productSrc="+productSrc);
        Usercart usercart=new Usercart();
        usercart.setProductId(productId);
        usercart.setProductName(productName);
        usercart.setProductPrice(productPrice);
        usercart.setProductSrc(productSrc);

        if(usercartService.findProduct(productId)!=null){
            Usercart product1=usercartService.findProduct(productId);
            int num=product1.getProductNunber();
            num++;
            usercart.setProductNunber(num);
            if(usercartService.updateProduct(usercart)!=0){
                return QQResponse.ok(usercart);
            }else {
                return QQResponse.fail(2,"更新数据库失败");
            }
        }else {
            usercart.setProductNunber(1);
            if(usercartService.addProduct(usercart)!=0){
                return QQResponse.ok(usercart);
            }else {
                return QQResponse.fail(1,"加入数据库失败");
            }
        }

    }

}

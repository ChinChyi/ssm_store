package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.UsercartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: demo
 * @description: 主页面控制器
 * @author: Mr.Qin
 * @create: 2019-12-05 21:30
 **/
@Controller
@RequestMapping("index")
public class IndexController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UsercartService usercartService;

    @RequestMapping("/selfIndex")
    public String gotoIndex(Model model){
        model.addAttribute("cart",usercartService.lodeProductCart());
        return "index.html";
    }

    @RequestMapping("/shop")
    public String gotoShop(@RequestParam(value = "page",required = false,defaultValue = "1")int page,@RequestParam(value = "price",defaultValue = "$0 - $800")String price,
                           @RequestParam(value = "search" , defaultValue = "0") String search, Model model){
        //calculate price
        price=price.replace("$","");
        String[] prices=price.split("-");
        int startPrice=Integer.parseInt(prices[0].trim());
        int endPrice=Integer.parseInt(prices[1].trim());


        int pageSize=6;
        List<Product> productList=productService.lodeProduct(page,pageSize,startPrice,endPrice,search);

        //compute page size

        int totalSize;

        if(search.equals("0")) {
           totalSize = productService.count(startPrice, endPrice);
        }else {
            totalSize=productList.size();
        }

        //get list

        model.addAttribute("startPrice",startPrice);
        model.addAttribute("endPrice",endPrice);
        model.addAttribute("price","$"+startPrice+" - $"+endPrice);
        model.addAttribute("totalSize",totalSize);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("realPageSize",productList.size());
        model.addAttribute("totalPage",(totalSize-1)/pageSize+1);
        model.addAttribute("currentPage",page);
        model.addAttribute("list",productList);
        model.addAttribute("cart",usercartService.lodeProductCart());
        return "shop.html";
    }
    @RequestMapping("/product")
    public String gotoProduct(Model model){
        System.out.println(usercartService.lodeProductCart());
        model.addAttribute("cart",usercartService.lodeProductCart());
        return "product-details.html";
    }

}

package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: Mr.Qin
 * @create: 2019-12-10 22:45
 **/
@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public int count(int startPrice,int endPrice){
        return productMapper.count(startPrice,endPrice);
    }

    public List<Product> lodeProduct(int page, int pageSize, int startPrice, int endPrice,String search){
        if(search.equals("0")){
        int offset=(page-1)*pageSize;
        return productMapper.selectAll(offset,pageSize,startPrice,endPrice);
        }else {
            return productMapper.selectName(search);
        }
    }

    public int addProduct(Product product){

        return  productMapper.insert(product);
    }

    public Product findProduct(Integer productId){
        Product product=productMapper.selectByPrimaryKey(productId);
        return product;
    }

    public  int updateProduct(Product product){
        return productMapper.updateByPrimaryKey(product);
    }
}

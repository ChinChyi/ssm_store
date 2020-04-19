package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.entity.Usercart;
import com.example.demo.mapper.UsercartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @program: demo
 * @description:
 * @author: Mr.Qin
 * @create: 2019-12-11 16:47
 **/
@Service
public class UsercartService {

    @Autowired
    private UsercartMapper usercartMapper;

    //添加购物车
    public int addProduct(Usercart usercart){
        return usercartMapper.insert(usercart);
    }

    //跟更新购物车
    public int updateProduct(Usercart usercart){
        return usercartMapper.updateByPrimaryKey(usercart);
    }

    //查找商品
    public Usercart findProduct(Integer productId){
        return usercartMapper.selectByPrimaryKey(productId);
    }

    //返回商品列表
    public ArrayList<Usercart> lodeProductCart(){
        ArrayList<Usercart> list=new ArrayList<>();
        list=usercartMapper.selectAll();
        return list;
    }

    //删除商品
    public int deleteProduct(Integer id){
        return usercartMapper.deleteByPrimaryKey(id);
    }
}

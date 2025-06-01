package com.sangui.service;


import org.springframework.stereotype.Service;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description:
 * @Version: 1.0
 */
@Service
public class OrderService {
    /**
     * 生成订单业务方法
     */
    public void generate(){
        System.out.println("订单生成中......");
    }

    /**
     * 取消订单业务方法
     */
    public void cancel(){
        String s = null;
        System.out.println(s.toString());
        System.out.println("订单取消中......");

    }
}

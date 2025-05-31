package com.sangui.mall.client;


import com.sangui.mall.service.OrderService;
import com.sangui.mall.service.impl.OrderServiceImpl;
import com.sangui.mall.service.impl.OrderServiceImplSub;
import com.sangui.mall.service.impl.OrderServiceProxy;

import java.lang.reflect.Proxy;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-31
 * @Description:
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
//        OrderService orderService = new OrderServiceImpl();
//        //OrderService orderService = new OrderServiceImplSub();
//        orderService.generate();
//        orderService.detail();
//        orderService.modify();

        // 创建目标对象
        OrderService target = new OrderServiceImpl();
        // 创建代理对象
        OrderService proxy = new OrderServiceProxy(target);
        // 调用代理对象的代理方法
        proxy.generate();
        proxy.detail();
        proxy.modify();

    }
}

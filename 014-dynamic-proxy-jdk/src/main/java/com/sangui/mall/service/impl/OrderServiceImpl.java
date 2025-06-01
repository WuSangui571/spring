package com.sangui.mall.service.impl;


import com.sangui.mall.service.OrderService;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-31
 * @Description:
 * @Version: 1.0
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public String getName() {
        System.out.println("getName method execute！！");
        return "zhangsan";
    }

    @Override
    public void generate() {
        // 假设这是业务代码，模拟实际项目生成订单耗时
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单已生成！！");
    }

    @Override
    public void modify() {
        //假设这是业务代码，模拟实际项目修改订单耗时
        try {
            Thread.sleep(456);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单已修改！！");
    }

    @Override
    public void detail() {
        //假设这是业务代码，模拟实际项目查询订单耗时
        try {
            Thread.sleep(111);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单请查看！！.........展开");
    }
}

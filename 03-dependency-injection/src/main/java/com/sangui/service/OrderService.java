package com.sangui.service;


import com.sangui.mapper.OrderMapper;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-27
 * @Description:
 * @Version: 1.0
 */
public class OrderService {
    OrderMapper orderMapper;

    public OrderMapper getOrderMapper() {
        return orderMapper;
    }

    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public void generate(){
        orderMapper.insertOrder();
    }
}

package com.sangui.service;


import com.sangui.dao.OrderDao;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-30
 * @Description:
 * @Version: 1.0
 */
public class OrderService {
    OrderDao orderDao;

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public String toString() {
        return "OrderService{" +
                "orderDao=" + orderDao +
                '}';
    }

    public OrderService() {
    }

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void save(){
        orderDao.insert();
    }
}

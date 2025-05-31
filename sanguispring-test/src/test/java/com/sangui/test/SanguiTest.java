package com.sangui.test;


import com.sangui.bean.Vip;
import com.sangui.dao.OrderDao;
import com.sangui.sanguispring.core.ApplicationContext;
import com.sangui.sanguispring.core.ClassPathXmlApplicationContext;
import com.sangui.service.OrderService;
import org.junit.Test;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-30
 * @Description:
 * @Version: 1.0
 */
public class SanguiTest {
    @Test
    public void test01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("sanguispring.xml");
        OrderService orderService = (OrderService)context.getBean("orderService");
        System.out.println("orderService=" + orderService);
        OrderDao orderDao = (OrderDao)context.getBean("orderDao");
        System.out.println("orderDao = " + orderDao);
        Vip vip = (Vip)context.getBean("vip");
        System.out.println("vip = " + vip);
        orderService.save();
    }
}

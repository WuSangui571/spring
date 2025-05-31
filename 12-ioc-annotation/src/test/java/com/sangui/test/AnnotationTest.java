package com.sangui.test;


import com.sangui.bean.*;
import com.sangui.bean3.MyDataSource;
import com.sangui.dao.OrderDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.sangui.SpringConfig;
import top.sangui.service.OrderService;

import javax.swing.*;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-31
 * @Description:
 * @Version: 1.0
 */
public class AnnotationTest {
    @Test
    public void testNoXML(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);
        orderService.save();
    }

    @Test
    public void testAnnotation4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
        OrderService orderService = context.getBean("orderService", OrderService.class);
        orderService.save();
    }

    @Test
    public void testAnnotation3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring3.xml");
        MyDataSource myDataSource = context.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);
    }

    @Test
    public void testAnnotation2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring2.xml");
//        A a = context.getBean("a", A.class);
//        System.out.println("对象A的实例：" + a);
    }
    @Test
    public void testAnnotation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
        Vip vip = context.getBean("vip", Vip.class);
        System.out.println(vip);
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
        Order order = context.getBean("order", Order.class);
        System.out.println(order);

        OrderDao orderDao = context.getBean("orderDao", OrderDao.class);
        System.out.println(orderDao);
    }
}

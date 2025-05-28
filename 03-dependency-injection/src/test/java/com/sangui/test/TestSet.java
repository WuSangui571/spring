package com.sangui.test;


import com.sangui.bean.User;
import com.sangui.mapper.UserMapper;
import com.sangui.mapper.impl.UserMapperImpl;
import com.sangui.service.OrderService;
import com.sangui.service.UserService;
import com.sangui.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-27
 * @Description:
 * @Version: 1.0
 */
public class TestSet {
    @Test
    public void testSimple(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("setdi.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
    }
    @Test
    public void testSetOrder() {
        ApplicationContext context = new ClassPathXmlApplicationContext("setdi.xml");
        OrderService orderService = context.getBean(OrderService.class);
        orderService.generate();
    }
    @Test
    public void testSetDI() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        UserMapper userMapperImplBean = context.getBean("userMapperImplBean", UserMapperImpl.class);
        System.out.println(userMapperImplBean);

//        UserMapper userMapperBean = context.getBean("userMapperImplBean", UserMapper.class);
//        System.out.println(userMapperBean);

        UserService userServiceImplBean = context.getBean("userServiceImplBean", UserServiceImpl.class);
        System.out.println(userServiceImplBean);

//        UserService userServiceBean = context.getBean("userServiceImplBean", UserService.class);
//        System.out.println(userServiceBean);
        userServiceImplBean.deleteUser();

    }
}

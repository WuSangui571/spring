package com.sangui.test;


import com.sangui.bean.*;
import com.sangui.jdbc.MyDataSource;
import com.sangui.jdbc.MyDataSource1;
import com.sangui.jdbc.MyDataSource2;
import com.sangui.mapper.UserMapper;
import com.sangui.mapper.impl.UserMapperImpl;
import com.sangui.service.OrderService;
import com.sangui.service.UserService;
import com.sangui.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.Date;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-27
 * @Description:
 * @Version: 1.0
 */
public class TestSet {
    @Test
    public void testProperties(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-properties.xml");
        MyDataSource myDataSource = context.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);
    }

    @Test
    public void testAutowire(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-autowire.xml");
        OrderService orderService = context.getBean("orderService", OrderService.class);
        orderService.generate();
    }

    @Test
    public void testPropUtil(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-util.xml");
        MyDataSource1 myDataSource1 = context.getBean("myDataSource1", MyDataSource1.class);
        System.out.println(myDataSource1);

        MyDataSource2 myDataSource2 = context.getBean("myDataSource2", MyDataSource2.class);
        System.out.println(myDataSource2);
    }

    @Test
    public void testP(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-p.xml");
        Dog dogBean = context.getBean("dogBean", Dog.class);
        System.out.println(dogBean);
    }

    @Test
    public void testSetNull(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-connection.xml");
        Cat catBean = ctx.getBean("catBean", Cat.class);
        System.out.println(catBean);
    }

    @Test
    public void testCollection(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-connection.xml");
        Person personBean = context.getBean("personBean", Person.class);
        System.out.println(personBean);
    }

    @Test
    public void testQian(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-array.xml");
        YuQian yuQianBean = context.getBean("yuQianBean", YuQian.class);
        System.out.println(yuQianBean);
    }

    @Test
    public void testCascade(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("cascade.xml");
        Clazz clazzBean = ctx.getBean("clazzBean", Clazz.class);
        System.out.println(clazzBean);
        Student studentBean = ctx.getBean("studentBean", Student.class);
        System.out.println(studentBean);
    }

    @Test
    public void testDataSource(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("setdi.xml");
        MyDataSource myDataSourceBean = ac.getBean("myDataSourceBean", MyDataSource.class);
        System.out.println(myDataSourceBean);
    }

    @Test
    public void testSimpleType(){
//        Date date = new Date();
//        System.out.println(date);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("setdi.xml");
        SimpleValueType simpleValueTypeBean = applicationContext.getBean("simpleValueTypeBean", SimpleValueType.class);

        System.out.println(simpleValueTypeBean);
    }

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

package com.sangui.test;


import com.sangui.bean.Student;
import com.sangui.bean.User;
import com.sangui.bean.Vip;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description:
 * @Version: 1.0
 */
public class LifecycleTest {
    @Test
    public void registerBean(){
        Student student = new Student();
        System.out.println(student);
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("student",student);
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Student student1 = factory.getBean("student", Student.class);
        System.out.println(student1);
    }

    @Test
    public void testBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Vip vip = context.getBean("vip", Vip.class);
        System.out.println(vip);
    }

    @Test
    public void testLifecycle(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        User user = context.getBean("user", User.class);
        System.out.println("Step4.使用User:" + user + " ！！");
        ClassPathXmlApplicationContext classPathXmlApplicationContext = (ClassPathXmlApplicationContext) context;
        classPathXmlApplicationContext.close();
    }
}

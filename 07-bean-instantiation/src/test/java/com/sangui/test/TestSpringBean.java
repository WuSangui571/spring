package com.sangui.test;


import com.sangui.bean.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description:
 * @Version: 1.0
 */
public class TestSpringBean {
    @Test
    public void testFactory5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        context.getBean("student",Student.class);
    }

    @Test
    public void testFactory4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }

    @Test
    public void testFactory3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void testFactory2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Gun gunBean = context.getBean("gunBean", Gun.class);
        System.out.println(gunBean);
    }

    @Test
    public void testFactory(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Star starBean = context.getBean("starBean", Star.class);
        System.out.println(starBean);
    }

    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        SpringBean springBean = ac.getBean("springBean", SpringBean.class);
        System.out.println(springBean);
    }
}

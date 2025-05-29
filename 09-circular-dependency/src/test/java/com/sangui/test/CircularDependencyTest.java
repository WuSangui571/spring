package com.sangui.test;


import com.sangui.bean.Husband;
import com.sangui.bean.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description:
 * @Version: 1.0
 */
public class CircularDependencyTest {
    @Test
    public void testHusband2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring2.xml");
        Husband husband = context.getBean("husband", Husband.class);
        System.out.println(husband);
        Wife wife = context.getBean("wife", Wife.class);
        System.out.println(wife);
    }

    @Test
    public void testHusband(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Husband husband = context.getBean("husband", Husband.class);
        System.out.println(husband);
        Wife wife = context.getBean("wife", Wife.class);
        System.out.println(wife);
    }
}

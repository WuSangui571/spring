package com.sangui.test;


import com.sangui.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description:
 * @Version: 1.0
 */
public class AopTest {
    @Test
    public void testAop() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.login();
    }
}

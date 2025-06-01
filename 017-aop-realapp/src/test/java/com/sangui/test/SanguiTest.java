package com.sangui.test;


import com.sangui.service.AccountService;
import com.sangui.service.OrderService;
import com.sangui.service.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description:
 * @Version: 1.0
 */
public class SanguiTest {
    @Test
    public void test01(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);
        AccountService accountService = context.getBean("accountService", AccountService.class);
//        orderService.generate();
        orderService.cancel();

//        accountService.transfer();
//        accountService.withdraw();

    }
}

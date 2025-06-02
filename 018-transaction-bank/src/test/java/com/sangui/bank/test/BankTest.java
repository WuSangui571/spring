package com.sangui.bank.test;


import com.sangui.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-02
 * @Description:
 * @Version: 1.0
 */
public class BankTest {
    @Test
    public void testTransfer(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = context.getBean("accountServiceImpl", AccountService.class);
        try {
            accountService.transfer("act-001","act-002",10000.0);
            System.out.println("转账成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

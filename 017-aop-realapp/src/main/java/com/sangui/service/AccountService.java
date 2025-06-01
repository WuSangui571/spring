package com.sangui.service;


import org.springframework.stereotype.Service;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description:
 * @Version: 1.0
 */
@Service
public class AccountService {
    /**
     * 转账业务方法
     */
    public void transfer(){
        System.out.println("转账中......");
    }

    /**
     * 取款业务方法
     */
    public void withdraw(){
        System.out.println("取款中......");
    }
}

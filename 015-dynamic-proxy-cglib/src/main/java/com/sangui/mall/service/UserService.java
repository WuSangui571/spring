package com.sangui.mall.service;


/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description:
 * @Version: 1.0
 */
public class UserService {
    public boolean login(String username, String password){
        System.out.println("正在验证身份中......");
        if ("admin".equals(username) && "123".equals(password)){
            return true;
        }
        return false;
    }
    public void logout(){
        System.out.println("退出系统中......");
    }
}

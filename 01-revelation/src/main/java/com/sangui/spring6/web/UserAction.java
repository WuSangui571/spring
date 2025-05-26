package com.sangui.spring6.web;


import com.sangui.spring6.service.UserService;
import com.sangui.spring6.service.impl.UserServiceImpl;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-26
 * @Description:
 * @Version: 1.0
 */
public class UserAction  {
    private UserService userService;
//    private UserService userService = new UserServiceImpl();
    public void deleteRequest(){
        userService.deleteUser();
    }
}

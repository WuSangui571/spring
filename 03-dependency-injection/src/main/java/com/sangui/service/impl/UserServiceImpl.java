package com.sangui.service.impl;


import com.sangui.mapper.UserMapper;
import com.sangui.service.UserService;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-27
 * @Description:
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {
    UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void deleteUser() {
        userMapper.delete();
    }

}

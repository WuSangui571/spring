package com.sangui.spring6.service.impl;


import com.sangui.spring6.mapper.UserMapper;
import com.sangui.spring6.mapper.impl.UserMapperImplForMySQL;
import com.sangui.spring6.mapper.impl.UserMapperImplForOracle;
import com.sangui.spring6.service.UserService;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-26
 * @Description:
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {
    UserMapper userMapper;
//    UserMapper userMapper = new UserMapperImplForOracle();
//    UserMapper userMapper = new UserMapperImplForMySQL();
    @Override
    public void deleteUser() {
        userMapper.deleteUserById(1);
    }

}

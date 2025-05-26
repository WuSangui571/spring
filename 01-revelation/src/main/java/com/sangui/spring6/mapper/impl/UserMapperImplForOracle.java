package com.sangui.spring6.mapper.impl;


import com.sangui.spring6.mapper.UserMapper;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-26
 * @Description:
 * @Version: 1.0
 */
public class UserMapperImplForOracle implements UserMapper {
    @Override
    public void deleteUserById(int id) {
        System.out.println("Oracle 数据库正在删除用户信息...");
    }
}

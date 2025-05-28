package com.sangui.mapper.impl;


import com.sangui.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-27
 * @Description:
 * @Version: 1.0
 */
public class UserMapperImpl implements UserMapper {
    private static final Logger logger = LoggerFactory.getLogger(UserMapperImpl.class);
    @Override
    public void delete() {
        logger.info("数据库已删除信息！");
    }
}

package com.sangui.mall.service;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-31
 * @Description:
 * @Version: 1.0
 */
public interface OrderService {
    /**
     * 测试有返回值的情况
     * @return 字符串
     */
    String getName();

    /**
     * 生成订单
     */
    void generate();

    /**
     * 修改订单信息
     */
    void modify();

    /**
     * 查看订单明细
     */
    void detail();
}

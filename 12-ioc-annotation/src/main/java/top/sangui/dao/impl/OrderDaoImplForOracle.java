package top.sangui.dao.impl;


import top.sangui.dao.OrderDao;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-31
 * @Description:
 * @Version: 1.0
 */
//@Repository
public class OrderDaoImplForOracle implements OrderDao {
    @Override
    public void insert() {
        System.out.println("Oracle 正在保存订单信息！！！");
    }
}

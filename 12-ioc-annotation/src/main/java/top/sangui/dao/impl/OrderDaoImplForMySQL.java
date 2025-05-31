package top.sangui.dao.impl;


import org.springframework.stereotype.Repository;
import top.sangui.dao.OrderDao;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-31
 * @Description:
 * @Version: 1.0
 */
@Repository
public class OrderDaoImplForMySQL implements OrderDao {
    @Override
    public void insert() {
        System.out.println("MySQL正在保存订单信息！！！");
    }
}

package top.sangui.service;


import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import top.sangui.dao.OrderDao;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-31
 * @Description:
 * @Version: 1.0
 */
@Service
public class OrderService {

    @Resource
    //@Autowired
    //@Qualifier("orderDaoImplForOracle")
    //@Qualifier("orderDaoImplForMySQL")
    OrderDao orderDao;
    public void save() {
        orderDao.insert();
    }

    public OrderService() {
    }

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public String toString() {
        return "OrderService{" +
                "orderDao=" + orderDao +
                '}';
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}

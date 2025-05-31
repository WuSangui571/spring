package com.sangui.mall.service.impl;


import com.sangui.mall.service.OrderService;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-31
 * @Description: 代理对象
 * @Version: 1.0
 */
public class OrderServiceProxy implements OrderService {
    /**
     * 解决方法三：生成代理类
     * OrderServiceProxy 里的方法就是代理方法
     * OrderServiceImpl 里的方法就是目标方法
     * OrderService 就是公共的接口
     * 解决方法三解决了 OCP 问题，使用实现而不是继承关系，降低了耦合度
     * 目前使用的是静态代理，静态代理的缺点就是：
     * 一个目标类就得生成一个代理类，实际开发中若有一百个目标类，就得写一百个代理类，会导致类爆炸，不好维护
     * 于是会有了解决方法四，使用动态代理
     * （动态代理也是代理模式，只不过添加了字节码生成技术，可以在内存中动态的生成一个对应的class字节码，这个字节码就是我们的代理类）
     */

    // 将目标对象作为代理对象的一个属性，这种关系叫做关联关系，比继承关系的耦合度低
    // 注意这里要写 OrderService （公共接口），不能是 OrderServiceImpl ，因为公共接口耦合度低
    private OrderService target;

    // 构造方法
    public OrderServiceProxy(OrderService target) {
        this.target = target;
    }

    public OrderServiceProxy() {
    }

    @Override
    public void generate() {
        long begin = System.currentTimeMillis();
        target.generate();
        long end = System.currentTimeMillis();
        System.out.println("生成订单耗时：" + (end - begin) + "ms");
    }

    @Override
    public void modify() {
        long begin = System.currentTimeMillis();
        target.modify();
        long end = System.currentTimeMillis();
        System.out.println("生成订单耗时：" + (end - begin) + "ms");
    }

    @Override
    public void detail() {
        long begin = System.currentTimeMillis();
        target.detail();
        long end = System.currentTimeMillis();
        System.out.println("生成订单耗时：" + (end - begin) + "ms");
    }
}

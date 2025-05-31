package com.sangui.mall.service.impl;


import com.sangui.mall.service.OrderService;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-31
 * @Description:
 * @Version: 1.0
 */
public class OrderServiceImpl implements OrderService {
    /**
     * 假设项目上线一年后，项目经理提出，要计算每个业务的具体耗时时间的新业务
     * 于是乎，就有了解决方法一：在每个业务方法里编写三行代码，计算这个业务的耗时。
     * 这种方式当然可以得出每个业务的耗时时间，
     * 缺点一：但是，这明显违背 OCP 开发原则，即在扩展新功能时，改变原代码
     * 缺点二：每个业务方法种都写了相同的代码，代码没得到复用
     * 以下注释内容是解决方法一的代码：
     */
//    @Override
//    public void generate() {
//        long begin = System.currentTimeMillis();
//        // 假设这是业务代码，模拟实际项目生成订单耗时
//        try {
//            Thread.sleep(1234);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("订单已生成！！");
//        long end = System.currentTimeMillis();
//        System.out.println("生成订单耗时：" + (end - begin) + "ms");
//    }
//
//    @Override
//    public void modify() {
//        long begin = System.currentTimeMillis();
//        //假设这是业务代码，模拟实际项目修改订单耗时
//        try {
//            Thread.sleep(456);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("订单已修改！！");
//        long end = System.currentTimeMillis();
//        System.out.println("修改订单耗时：" + (end - begin) + "ms");
//    }
//
//    @Override
//    public void detail() {
//        long begin = System.currentTimeMillis();
//        //假设这是业务代码，模拟实际项目查询订单耗时
//        try {
//            Thread.sleep(111);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("订单请查看！！.........展开");
//        long end = System.currentTimeMillis();
//        System.out.println("查看订单明细耗时：" + (end - begin) + "ms");
//    }

    /**
     * 解决方法二：编写一个业务类的子类，让子类继承业务类，对每个业务方法进行重写
     * 详细代码见同包下的 OrderServiceImplSub.java ，这就是 OrderServiceImpl 的子类
     */
    @Override
    public void generate() {
        // 假设这是业务代码，模拟实际项目生成订单耗时
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单已生成！！");
    }

    @Override
    public void modify() {
        //假设这是业务代码，模拟实际项目修改订单耗时
        try {
            Thread.sleep(456);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单已修改！！");
    }

    @Override
    public void detail() {
        //假设这是业务代码，模拟实际项目查询订单耗时
        try {
            Thread.sleep(111);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单请查看！！.........展开");
    }
}

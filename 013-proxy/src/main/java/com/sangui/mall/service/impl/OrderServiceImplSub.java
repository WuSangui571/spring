package com.sangui.mall.service.impl;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-31
 * @Description:
 * @Version: 1.0
 */
public class OrderServiceImplSub extends OrderServiceImpl{
    /**
     * 这个解决方法解决了违反 OCP 原则的问题，即为了扩展新功能，不在源程序中进行修改
     * 但是，这种解决方法也有缺点，
     * 缺点一：耦合度很高，继承关系是一种耦合关系很高的关系，不建议使用
     * 缺点二：还是没解决代码复用的问题，即用一段代码重复写
     * 还有没有更好的解决方法？
     * 解决方案三，就是采用代理模式
     */
    @Override
    public void detail() {
        long begin = System.currentTimeMillis();
        super.detail();
        long end = System.currentTimeMillis();
        System.out.println("查看订单明细耗时：" + (end - begin) + "ms");
    }

    @Override
    public void modify() {
        long begin = System.currentTimeMillis();
        super.modify();
        long end = System.currentTimeMillis();
        System.out.println("修改订单耗时：" + (end - begin) + "ms");
    }

    @Override
    public void generate() {
        long begin = System.currentTimeMillis();
        super.generate();
        long end = System.currentTimeMillis();
        System.out.println("生成订单耗时：" + (end - begin) + "ms");
    }
}

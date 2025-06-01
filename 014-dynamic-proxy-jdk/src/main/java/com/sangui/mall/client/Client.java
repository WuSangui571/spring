package com.sangui.mall.client;


import com.sangui.mall.service.OrderService;
import com.sangui.mall.service.TimerInvocationHandler;
import com.sangui.mall.service.impl.OrderServiceImpl;
import com.sangui.mall.utils.ProxyUtil;

import java.lang.reflect.Proxy;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description:
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 创建目标对象
        OrderService target = new OrderServiceImpl();
        // 创建代理对象
        /**
         * 这是新建代理对象代码，
         * 本质上，这个方法做了两件事：在内存中动态生成了代理类的字节码class，和new对象了
         * 关于这个方法的三个参数，含义，怎么用。
         * 1.ClassLoader loader
         *      类加载器，在内存中生成的字节码也是class文件，要执行也得加载到内存中，加载类就需要类加载器，所以这里要指定类加载器
         *      目标类的类加载器 必须和代理类的加载器一致
         * 2.Class<?>[] interfaces
         *      代理类和目标类要实现同一个接口，或同一些接口
         * 3.InvocationHandler h
         *      调用处理器，这是个接口
         *      在调用处理器中编写的就是：增强代码
         *      因为具体要什么代码，JDK代理技术它是不知道的
         *      既然是接口，那一定要写实现类
         *          为什么？------你可能会有疑问，为什么还会动手写接口的实现类，这不会类爆炸吗？不会，
         *          因为这种调用处理器写一次就好
         * 注意：代理对象和目标对象实现的接口一样，所以可以向下转型
         */
//        OrderService proxy = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
//                                                                   target.getClass().getInterfaces(),
//                                                                   new TimerInvocationHandler(target));
//
        OrderService proxy = (OrderService)ProxyUtil.newProxyInstance(target);
        // 调用代理对象的代理方法
        proxy.detail();
        proxy.modify();
        proxy.generate();
        String s = proxy.getName();
        System.out.println(s);

    }
}

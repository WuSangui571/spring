package com.sangui.mall.utils;


import com.sangui.mall.service.TimerInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description:
 * 对
 * OrderService proxy = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
 *                                                                    target.getClass().getInterfaces(),
 *                                                                    new TimerInvocationHandler(target));
 * 这一段代码进行的封装
 * @Version: 1.0
 */
public class ProxyUtil {
    private ProxyUtil() {
    }
    public static Object newProxyInstance(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TimerInvocationHandler(target));
    }
}

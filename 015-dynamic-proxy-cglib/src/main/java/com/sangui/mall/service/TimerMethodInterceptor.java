package com.sangui.mall.service;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description:
 * @Version: 1.0
 */
public class TimerMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long begin = System.currentTimeMillis();
        Object returnValue = methodProxy.invokeSuper(o, objects);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin) + "ms");
        return returnValue;
    }
}

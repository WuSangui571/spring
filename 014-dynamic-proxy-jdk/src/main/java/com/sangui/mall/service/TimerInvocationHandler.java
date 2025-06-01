package com.sangui.mall.service;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description: 专门负责计时的调用处理器对象
 * @Version: 1.0
 */
public class TimerInvocationHandler implements InvocationHandler {
    Object target;

    public TimerInvocationHandler() {
    }

    public TimerInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 1.为什么强行要求必须实现 InvocationHandler 接口？
     *      因为一个类的 实现接口必须要实现接口中的方法
     *      一下这个方法必须是 invoke()，因为JDK是在底层调用 invoke（）方法的程序已经提前写好了
     *      注意：invoke方法不是我们程序员负责调用的，
     * 2.invoke方法什么时候被调用？
     *      当代理对象调用代理方法的时候，就会被调用
     * 3.invoke方法里的三个参数
     *      第一个参数：proxy
     *          是代理对象，这个参数使用较少
     *      第二个参数：method
     *          是目标对象的目标对象，要执行的方法就是它
     *      第三个参数：args
     *          是目标方法上的参数，即实参
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //System.out.println(proxy);
        long begin = System.currentTimeMillis();
        Object returnValue = method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin) + "ms");
        return returnValue;
    }
}

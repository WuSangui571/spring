package com.sangui.mall.client;


import com.sangui.mall.service.TimerMethodInterceptor;
import com.sangui.mall.service.UserService;
import net.sf.cglib.proxy.Enhancer;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description: 客户端程序
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 创建字节码增强器对象
        Enhancer enhancer = new Enhancer();

        // 告诉CGLIB父类是谁，即目标类是谁。
        enhancer.setSuperclass(UserService.class);

        // 设置回调（等同于JDK动态代理当中的调用处理器，InvocationHandler）
        enhancer.setCallback(new TimerMethodInterceptor());

        // 创建代理对象（Step1:在内存中生成子类，即代理类的字节码文件，Step2:创建代理对象）
        UserService agent = (UserService) enhancer.create();

        agent.login("admin", "123");
        agent.login("admin","123456");
        agent.logout();
    }
}

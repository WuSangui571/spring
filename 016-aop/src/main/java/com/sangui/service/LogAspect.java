package com.sangui.service;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description: 这是一个切面（切面 = 通知 + 切点）
 * 通知就是增强，就是要写具体的要编写的增强代码
 * 这里通知Advice以方法的形式出现。（因为方法中可以写代码）
 * @Version: 1.0
 */
@Component
@Aspect
public class LogAspect {
    @Before("execution(* com.sangui.service.*Service.login(..))")
    public void beforeAdvice(){
        System.out.println("我是一个通知，是一段增强代码--------");
    }
}

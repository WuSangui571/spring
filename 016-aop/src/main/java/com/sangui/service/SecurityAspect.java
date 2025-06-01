package com.sangui.service;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description:
 * @Version: 1.0
 */
@Aspect
@Component
@Order(1)
public class SecurityAspect {
    @Pointcut("execution(* com.sangui.service.*Service.*(..))")
    public void exe(){}

    @Before("exe()")
    public void beforeAdvice(){
        System.out.println("SecurityAspect 的 前切面代码");
    }

    @AfterReturning("exe()")
    public void afterReturningAdvice(){
        System.out.println("SecurityAspect 的 后切面代码");
    }
}

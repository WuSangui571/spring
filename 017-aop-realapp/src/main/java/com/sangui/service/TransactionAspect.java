package com.sangui.service;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description: 事务切面
 * @Version: 1.0
 */
@Component
@Aspect
public class TransactionAspect {

    @Around("execution(* com.sangui.service.*.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint pjp){


        Object proceed = null;
        try {
            // 开启事务
            System.out.println("开启事务....");

            proceed = pjp.proceed();

            // 关闭事务
            System.out.println("提交事务中....");
        } catch (Throwable e) {
            System.out.println("回滚事务中....");
            e.printStackTrace();
        }


        return proceed;
    }
}

package com.sangui.service;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description: 这是一个切面（切面 = 通知 + 切点）
 * 通知就是增强的代码，就是要写具体的要编写的增强代码
 * 这里通知 Advice 以方法的形式出现。（因为方法中可以写代码）
 * @Version: 1.0
 */
@Component
@Aspect
@Order(2)
public class LogAspect {
    @Pointcut("execution(* com.sangui.service.*Service.*(..))")
    public void exe(){}

    @Before("exe()")
    public void beforeAdvice(){
        System.out.println("我是一段 *前* 增强代码 Advice--------");
    }

    @AfterReturning("exe()")
    public void afterReturningAdvice(){
        System.out.println("我是一段 *后* 增强代码 Advice--------");
    }

//    @Around("execution(* com.sangui.service.*Service.log*(..))")
//    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("我是一段 *前环绕* 增强代码 Advice--------");
//        // 执行目标
//        pjp.proceed();
//        System.out.println("我是一段 *后环绕* 增强代码 Advice--------");
//        return null;
//    }
//
//    @AfterThrowing("execution(* com.sangui.service.*Service.log*(..))")
//    public Object afterThrowingAdvice(){
//        System.out.println("我是一段 *异常* 增强代码 Advice--------");
//        return null;
//    }
//
//    @After("execution(* com.sangui.service.*Service.log*(..))")
//    public Object afterAdvice(){
//        System.out.println("我是一段 *最终* 增强代码 Advice--------");
//        return null;
//    }
}

package com.sangui.bean;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description: 日志Bean后处理器
 * @Version: 1.0
 */
public class LogBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Step2.5：执行Bean后处理器的Before方法被调用了！！");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Step3 .5：执行Bean后处理器的After方法被调用了！！");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}

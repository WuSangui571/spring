package com.sangui.service;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description:
 * @Version: 1.0
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.sangui.service")
public class SpringConfig {
}

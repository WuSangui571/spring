package com.sangui;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description:
 * @Version: 1.0
 */
@Configuration
@ComponentScan("com.sangui.service")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {
}

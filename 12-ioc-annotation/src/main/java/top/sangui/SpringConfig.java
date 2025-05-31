package top.sangui;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-31
 * @Description:
 * @Version: 1.0
 */
@Configuration
//@ComponentScan("top.sangui")
@ComponentScan({"top.sangui.dao","top.sangui.service"})
public class SpringConfig {
}

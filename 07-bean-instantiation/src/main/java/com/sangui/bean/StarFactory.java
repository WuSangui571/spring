package com.sangui.bean;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description: 简单工厂模式中的工厂类角色。
 * @Version: 1.0
 */
public class StarFactory {
    // 静态方法
    public static Star getStar(){
        return new Star();
    }
}

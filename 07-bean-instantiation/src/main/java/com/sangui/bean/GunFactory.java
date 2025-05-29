package com.sangui.bean;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description: 工厂方法模式当中的，具体工厂角色
 * @Version: 1.0
 */
public class GunFactory {
    // 这里是实例方法
    public Gun get(){
        return new Gun();
    }
}

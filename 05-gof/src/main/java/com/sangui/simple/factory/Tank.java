package com.sangui.simple.factory;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-28
 * @Description: 具体产品角色：坦克
 * @Version: 1.0
 */
public class Tank extends Weapon{
    @Override
    public void attack() {
        System.out.println("坦克正在开炮！！");
    }
}

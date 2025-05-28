package com.sangui.simple.factory;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-28
 * @Description: 具体产品角色：战斗机
 * @Version: 1.0
 */
public class Fighter extends Weapon{
    @Override
    public void attack() {
        System.out.println("战斗机抛下小男孩！！");
    }
}

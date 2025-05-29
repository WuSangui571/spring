package com.sangui.factory.method;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description: 具体产品角色：Gun
 * @Version: 1.0
 */
public class Gun extends Weapon{
    @Override
    public void attack() {
        System.out.println("枪开始射击了！！");
    }
}

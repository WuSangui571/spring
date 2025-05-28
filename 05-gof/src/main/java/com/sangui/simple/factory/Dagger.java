package com.sangui.simple.factory;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-28
 * @Description: 具体产品角色：匕首
 * @Version: 1.0
 */
public class Dagger extends Weapon{
    @Override
    public void attack() {
        System.out.println("匕首正在攻击！！");
    }
}

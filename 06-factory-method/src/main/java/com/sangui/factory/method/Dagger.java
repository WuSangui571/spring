package com.sangui.factory.method;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description: 具体产品角色：Dagger
 * @Version: 1.0
 */
public class Dagger extends Weapon{
    @Override
    public void attack() {
        System.out.println("匕首开始攻击了！！");
    }
}

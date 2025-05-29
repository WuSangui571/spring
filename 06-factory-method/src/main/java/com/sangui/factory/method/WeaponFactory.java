package com.sangui.factory.method;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description: 抽象工厂角色
 * @Version: 1.0
 */
abstract public class WeaponFactory {
    /**
     * 这个方法不是静态的。是实例方法
     * @return 返回武器
     */
    abstract public Weapon get();
}

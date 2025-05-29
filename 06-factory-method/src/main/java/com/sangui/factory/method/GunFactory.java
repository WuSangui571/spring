package com.sangui.factory.method;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description: 具体工厂角色： GunFactory
 * @Version: 1.0
 */
public class GunFactory extends WeaponFactory{
    @Override
    public Weapon get() {
        return new Gun();
    }
}

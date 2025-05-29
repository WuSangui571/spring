package com.sangui.factory.method;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description: 客户端程序
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        WeaponFactory weaponFactory1 = new DaggerFactory();
        WeaponFactory weaponFactory2 = new GunFactory();
        Weapon weapon1 = weaponFactory1.get();
        Weapon weapon2 = weaponFactory2.get();
        weapon1.attack();
        weapon2.attack();
    }
}

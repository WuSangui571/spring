package com.sangui.simple.factory;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-28
 * @Description: 工厂类角色：武器工厂
 * @Version: 1.0
 */
public class WeaponFactory {
    /**
     * 静态方法，要获取什么产品，就看你传什么参数，传 TANK 获取坦克，传 DAGGER 获取匕首，传 FIGHTER 获取战斗机
     * @param weaponType
     * @return
     */
    public static Weapon get(String weaponType){
        if ("TANK".equals(weaponType)) {
            return new Tank();
        }
        if ("DAGGER".equals(weaponType)){
            return new Dagger();
        }
        if ("FIGHTER".equals(weaponType)){
            return new Fighter();
        }

        return null;

    }
}

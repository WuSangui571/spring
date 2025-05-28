package com.sangui.bean;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-28
 * @Description:
 * @Version: 1.0
 */
public class Clazz {
    String name;

    @Override
    public String toString() {
        return "Clazz{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}

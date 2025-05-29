package com.sangui.bean2;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description:
 * @Version: 1.0
 */
public class Wife {
    private String name;
    private Husband husband;

    @Override
    public String toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                ", husband Name =" + husband.getName() +
                '}';
    }

    public String getName() {
        return name;
    }

    public Wife() {
    }

    public Wife(String name, Husband husband) {
        this.name = name;
        this.husband = husband;
    }
}

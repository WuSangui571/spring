package com.sangui.bean;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description:
 * @Version: 1.0
 */
public class Husband {
    @Override
    public String toString() {
        return "Husband{" +
                "name='" + name + '\'' +
                ", wife Name =" + wife.getName() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    private String name;
    private Wife wife;
}

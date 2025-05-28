package com.sangui.bean;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-28
 * @Description:
 * @Version: 1.0
 */
public class Woman {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Woman{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

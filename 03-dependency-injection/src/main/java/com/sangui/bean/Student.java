package com.sangui.bean;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-28
 * @Description:
 * @Version: 1.0
 */
public class Student {

    private String name;
    private Clazz clazz;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", clazz=" + clazz +
                '}';
    }

    public String getName() {
        return name;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public void setName(String name) {
        this.name = name;
    }
}

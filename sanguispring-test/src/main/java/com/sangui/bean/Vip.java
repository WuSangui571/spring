package com.sangui.bean;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-30
 * @Description:
 * @Version: 1.0
 */
public class Vip{
    private String name;
    private int age;
    private Double height;

    @Override
    public String toString() {
        return "Vip{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    public Vip() {
    }

    public Vip(String name, int age, Double height) {
        this.name = name;
        this.age = age;
        this.height = height;
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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}

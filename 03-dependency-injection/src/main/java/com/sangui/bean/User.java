package com.sangui.bean;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-28
 * @Description:
 * @Version: 1.0
 */
public class User {
    private String username;
    private String password;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

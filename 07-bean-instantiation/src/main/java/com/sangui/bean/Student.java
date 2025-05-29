package com.sangui.bean;


import java.util.Date;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description:
 * @Version: 1.0
 */
public class Student {
    private Date birthday;

    @Override
    public String toString() {
        return "Student{" +
                "birthday=" + birthday +
                '}';
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}

package com.sangui.bean2;


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


    public Husband() {
    }

    public Husband(String name, Wife wife) {
        this.name = name;
        this.wife = wife;
    }

    private String name;
    private Wife wife;
}

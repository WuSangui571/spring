package com.sangui.bean;


import java.util.Arrays;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-28
 * @Description:
 * @Version: 1.0
 */
public class YuQian {
    private String[] hobby;

    private Woman[] women;

    @Override
    public String toString() {
        return "YuQian{" +
                "hobby=" + Arrays.toString(hobby) +
                ", women=" + Arrays.toString(women) +
                '}';
    }

    public Woman[] getWomen() {
        return women;
    }

    public void setWomen(Woman[] women) {
        this.women = women;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }
}

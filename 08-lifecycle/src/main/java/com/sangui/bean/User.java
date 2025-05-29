package com.sangui.bean;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description: Bean的生命周期按照粗略的五步的话，分为：
 * 1.实例化Bean（调用无参构造）
 * 2.给Bean的属性赋值（调用Set方法）
 * 3.初始化Bean（调用init方法，这个init方法需要自己写，自己配）
 * 4.使用Bean
 * 5.销毁Bean（调用destroy方法，这个destroy方法需要自己写，自己配）
 * @Version: 1.0
 */
public class User{




    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Step2.User的Set方法被调用了！！");
        this.name = name;
    }

    public User() {
        System.out.println("Step1.User的无参数构造被调用了！！");
    }

    // 这个方法需要自己配 自己写 方法名随意。
    public void initBean(){
        System.out.println("Step3.User的初始化方法被调用了！！");
    }

    // 这个方法也需要自己配 自己写，方法名随意。
    public void destroyBean(){
        System.out.println("Step5.User的销毁方法被调用了！！");
    }
}

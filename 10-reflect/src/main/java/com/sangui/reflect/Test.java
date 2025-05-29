package com.sangui.reflect;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description:
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        // 不使用反射机制
        SomeService someService = new SomeService();
        someService.doSome();
        String s1 = someService.doSome("hello");
        System.out.println(s1);
        String s2 = someService.doSome("hello", 101);
        System.out.println(s2);


    }
}

package com.sangui.reflect;


import java.lang.reflect.Method;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description:
 * @Version: 1.0
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.sangui.reflect.SomeService");
        Method doSome = clazz.getMethod("doSome", String.class, int.class);
        Object invoke = doSome.invoke(clazz.newInstance(), "张三", 1);
        System.out.println(invoke);
//        System.out.println(doSome);
//        Method[] declaredMethods = clazz.getDeclaredMethods();
//        for (Method m : declaredMethods) {
//            System.out.println(m);
//        }
    }
}

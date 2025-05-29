package com.sangui.reflect;


/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description:
 * @Version: 1.0
 */
public class SomeService {
    public void doSome(){
        System.out.println("doSome() 方法执行！！");
    }
    public String doSome(String s){
        System.out.println("doSome(String s) 方法执行！！");
        return s;
    }

    public String doSome(String s,int i){
        System.out.println("doSome(String s, int i) 方法执行！！");
        return s + i;
    }
}

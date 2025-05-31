package com.sangui.annotation.test;


import com.sangui.annotation.Component;
import org.junit.Test;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-31
 * @Description:
 * @Version: 1.0
 */
public class AnnotationTest {
    @Test
    public void testScan() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String packageName = "com.sangui.bean";
        Map<String,Object> map = new HashMap<>();
        String dirName = packageName.replace(".", "/");
        //System.out.println(dirName);
        URL url = ClassLoader.getSystemClassLoader().getResource(dirName);
        String path = url.getPath();
        System.out.println(path);
        File file = new File(path);
        File[]  files = file.listFiles();
        for (File file1 : files) {
            String beanName = packageName + "." + file1.getName().split("\\.")[0];
            //System.out.println(beanName);
            Class<?> clazz = Class.forName(String.valueOf(beanName));
            if (clazz.isAnnotationPresent(Component.class)) {
                System.out.println(beanName + " 有 Component 注解，注解值为：");
                Component annotation1 = clazz.getAnnotation(Component.class);
                System.out.println(annotation1.value());
                Object o = clazz.newInstance();
                map.put(annotation1.value(), o);
            }else{
                System.out.println(beanName + " 没有注解");
            }
        }
        System.out.println(map);
    }

    @Test
    public void testAnnotation(){
        try {
            Class<?> clazz = Class.forName("com.sangui.bean.User");
            boolean annotationPresent = clazz.isAnnotationPresent(Component.class);
            System.out.println("有无注解？---" + annotationPresent);
            Component annotation1 = clazz.getAnnotation(Component.class);
            System.out.println(annotation1.value());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

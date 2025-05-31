package com.sangui.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * @author sangui
 */
//标注注解的注解，叫做元注解，@Target注解用来修饰Component注解可以出现的位置。
// 一下表示Component注解可以出现在类上，属性上
//@Target(value = {ElementType.TYPE,ElementType.FIELD})
// 使用某个注解的时候，如果注解的属性名是value的话，value可以省略
//@Target({ElementType.TYPE,ElementType.FIELD})
// 且如果注解的属性值是个数组，并且数组中只有一个元素，则这个大括号可以省略
//@Target(ElementType.TYPE)
// Retention注解也是个元注解，RetentionPolicy.RUNTIME它表示@Component文件最终保留在class文件中，并且可以被反射机制读取
// RetentionPolicy.SOURCE表示这个注解只保留在java源文件中，意味着只起了编译的作业，override就是一种这种情况
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    // 定义注解的属性
    String value() default "";

    // 其他属性，属性名是name
    //String name();

    //String[] names();
}

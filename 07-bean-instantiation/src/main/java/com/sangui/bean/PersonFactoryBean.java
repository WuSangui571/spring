package com.sangui.bean;


import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description:
 * @Version: 1.0
 */
public class PersonFactoryBean implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}

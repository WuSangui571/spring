package com.sangui.bean;


import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description:
 * @Version: 1.0
 */
public class DateFactoryBean implements FactoryBean<Date> {
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DateFactoryBean{" +
                "date='" + date + '\'' +
                '}';
    }

    @Override
    public Date getObject() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(date);
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}

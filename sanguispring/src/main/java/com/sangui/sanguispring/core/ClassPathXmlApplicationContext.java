package com.sangui.sanguispring.core;


import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description:
 * @Version: 1.0
 */
public class ClassPathXmlApplicationContext implements ApplicationContext{
    private static Logger log = LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);
    private Map<String,Object> singletonMap = new HashMap<>();

    /**
     * 构造方法，解析 xml 文件 ，然后初始化所有的 Bean 对象
     * @param configLocation sanguispring配置文件的路径
     */
    public ClassPathXmlApplicationContext(String configLocation) {
        try {
            SAXReader saxReader = new SAXReader();
            InputStream inputStream = ClassPathXmlApplicationContext.class.getClassLoader().getResourceAsStream(configLocation);
            Document document = saxReader.read(inputStream);
            Element beans = document.getRootElement();
            List<Element> beanList = beans.elements("bean");
            for (Element bean : beanList) {
                String id = bean.attributeValue("id");
                String clazzStr = bean.attributeValue("class");
                log.info("bean id:{}, class:{}", id, clazzStr);
                Class<?> clazz = Class.forName(clazzStr);
                Object o = clazz.getDeclaredConstructor().newInstance();
                // 曝光
                singletonMap.put(id, o);
                log.info(singletonMap.toString());
                List<Element> propertyList = bean.elements("property");
                // 这里开始要重写，因为要先曝光，在赋值！！
                for (Element property : propertyList) {
                    String propertyName = property.attributeValue("name");
                    Field field = clazz.getDeclaredField(propertyName);
                    log.info("property name:{}", propertyName);
                    String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                    Method setMethod = clazz.getDeclaredMethod(setMethodName,field.getType());

                    String propertyValue = property.attributeValue("value");
                    if (propertyValue != null) {
                        setMethod.invoke(o,propertyValue);
                    }

                    String propertyRef = property.attributeValue("ref");
                    if (propertyRef != null) {
                        setMethod.invoke(o,);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String name) {
        return null;
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return null;
    }
}

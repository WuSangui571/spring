package com.sangui.bean;


import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-28
 * @Description: 注入List集合 和 Set集合
 * @Version: 1.0
 */
public class Person {
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Person{" +
                "properties=" + properties +
                ", map=" + map +
                ", nameList=" + nameList +
                ", addressSet=" + addressSet +
                '}';
    }

    private Map<Integer,String> map;

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    private List<String> nameList;

    private Set<String> addressSet;

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public Set<String> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<String> addressSet) {
        this.addressSet = addressSet;
    }
}

package com.sangui.sanguispring.test;


import com.sangui.sanguispring.core.ApplicationContext;
import com.sangui.sanguispring.core.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-29
 * @Description:
 * @Version: 1.0
 */
public class SanguispringTest {
    @Test
    public void testSanguispring(){
        ApplicationContext context = new ClassPathXmlApplicationContext("sanguispring.xml");
    }
}

package com.sangui.test;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-26
 * @Description:
 * @Version: 1.0
 */
public class TestSpring {
    @Test
    public void testFirstSpring() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Object userBean = context.getBean("userBean");
//        Object userMapperImplForMySQLBean = context.getBean("userMapperImplForMySQLBean");
        System.out.println(userBean);
        //System.out.println(userMapperImplForMySQLBean);
        Date nowTime = (Date) context.getBean("nowTime");
        Date nowTime1 = context.getBean("nowTime", Date.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String formatTime = sdf.format(nowTime);
        String formatTime1 = sdf.format(nowTime1);
        System.out.println(formatTime);
        System.out.println(formatTime1);

        // 获取 TestSpring 类的日志记录器对象，只要是这给类中的代码执行记录日志的话，就会输出相关的日志信息
        // import org.slf4j.Logger;
        Logger logger = LoggerFactory.getLogger(TestSpring.class);
        logger.info("输入 info 级别的日志");
        logger.debug("输入 debug 级别的日志");
        logger.error("输入 error 级别的日志");

    }
}

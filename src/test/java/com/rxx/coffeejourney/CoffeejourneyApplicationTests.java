package com.rxx.coffeejourney;

import com.rxx.coffeejourney.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Spring单元测试
 * 可以进行自动注入等容器的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CoffeejourneyApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testHelloService () {
        boolean b = ioc.containsBean("helloService");
        System.out.println(b);
    }

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

    @Test
    public void loggerTest() {

        //日志级别，由低到高，trace<debug<info<warn<error
        //可以调整需要输出的日志级别
        logger.trace("这是trace日志...");
        logger.debug("这是debug日志...");
        //SpringBoot默认的显示日志级别是info及以后的日志, 没有设定
        logger.info("这是info日志");
        logger.warn("这是warn日志");
        logger.error("这是error日志");

    }

}

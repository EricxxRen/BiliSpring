package com.rxx.coffeejourney;

import com.rxx.coffeejourney.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

}

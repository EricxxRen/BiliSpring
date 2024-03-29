package com.rxx.coffeejourney.config;

import com.rxx.coffeejourney.service.HelloService;
import com.rxx.coffeejourney.service.SuccessService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration指明当前类是一个配置类
 * 用来替代spring的配置文件，如bean.xml
 * 在配置文件中是用<bean></bean>标签添加组件的
 */
@Configuration
public class MyAppConfig {

    //将方法的返回值添加到容器中，容器中这个组件默认的id就是方法名
    @Bean
    public HelloService helloService () {
        System.out.println("配置类@Bean给容器中添加helloService组件");
        return new HelloService();
    }

    @Bean
    public SuccessService successService () {
        return new SuccessService();
    }
}

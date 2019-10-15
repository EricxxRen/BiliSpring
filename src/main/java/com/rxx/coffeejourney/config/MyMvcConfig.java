package com.rxx.coffeejourney.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 使用WebMvcConfigurer来扩展SpringMVC的功能
 * @EnableWebMvc 表示全面接管SpringMVC配置，SpringBoot的自动配置全部失效
 */
//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //添加视图控制器
        //浏览器发送rxx请求，会到success页面
        registry.addViewController("/rxx").setViewName("/success");
    }
}

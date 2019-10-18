package com.rxx.coffeejourney.config;

import com.rxx.coffeejourney.component.LoginHandlerIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
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
        registry.addViewController("/rxx").setViewName("success");
    }

    //所有的WebMvcConfigurationSupport会一起生效
    //@Bean将组建在容器中注册
    @Bean
    public WebMvcConfigurationSupport webMvcConfigurationSupport () {
        WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport() {
            @Override
            protected void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            protected void addInterceptors(InterceptorRegistry registry) {
                //.addPathPatterns("/**")表示需要拦截哪些请求，/**表示拦截任意多层下的任意请求
                registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html", "/", "/user/login");
            }
        };
        return webMvcConfigurationSupport;
    }
}

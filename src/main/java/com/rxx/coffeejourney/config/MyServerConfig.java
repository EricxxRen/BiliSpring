package com.rxx.coffeejourney.config;

import com.rxx.coffeejourney.filter.MyFilter;
import com.rxx.coffeejourney.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import java.util.Arrays;

@Configuration
public class MyServerConfig {

    //注册三大组件
    //注册Servlet
    @Bean
    public ServletRegistrationBean myServlet () {
        ServletRegistrationBean<Servlet> servletBean = new ServletRegistrationBean<>(new MyServlet(), "/myservlet");
        return servletBean;
    }

    //注册Filter
    @Bean
    public FilterRegistrationBean myFilter () {
        FilterRegistrationBean<Filter> filterBean = new FilterRegistrationBean<>();
        filterBean.setFilter(new MyFilter());
        filterBean.setUrlPatterns(Arrays.asList("/hello","/myservlet"));
        return filterBean;
    }

    //定制嵌入式servlet容器相关规则
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer () {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8087);
            }
        };
    }
}

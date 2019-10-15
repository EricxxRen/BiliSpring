package com.rxx.coffeejourney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

//@ImportResource(locations = "classpath:bean.xml")
@SpringBootApplication
public class CoffeejourneyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeejourneyApplication.class, args);
    }

    //添加自定义的视图解析器到容器中
    @Bean
    public ViewResolver myViewResolver () {
        return new MyViewResolver();
    }

    private static class MyViewResolver implements ViewResolver {
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }

}

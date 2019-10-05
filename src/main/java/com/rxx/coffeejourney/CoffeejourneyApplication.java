package com.rxx.coffeejourney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@ImportResource(locations = "classpath:bean.xml")
@SpringBootApplication
public class CoffeejourneyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeejourneyApplication.class, args);
    }

}

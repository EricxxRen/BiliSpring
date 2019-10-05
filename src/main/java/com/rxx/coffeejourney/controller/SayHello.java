package com.rxx.coffeejourney.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHello {

//    @Value("${person.last_name}")
    private String name;

    @RequestMapping("/sayHello")
    public String sayHello () {
        return "Hello, " + name;
    }
}

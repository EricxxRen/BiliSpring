package com.rxx.coffeejourney.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ResponseBody表示这个类的所有方法返回的数据直接写给浏览器（如果是对象可以转为json数据）
 * @ResponseBody
 * @Controller
 *
 * @RestController包含了@ResponseBody和@Controller
 * 当使用Restful API是采用@RestController
 * 需要使用静态页面时只需要@Controller标签
 */
@RestController
public class HelloWorld {

    @RequestMapping("/hello")
    public String hello () {
        return "Hello World";
    }

}

package com.rxx.coffeejourney.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ResponseBody表示这个类的所有方法返回的数据直接写给浏览器（如果是对象可以转为json数据）
 * @ResponseBody
 * @Controller
 *
 * @RestController包含了@ResponseBody和@Controller
 */
@RestController
public class HelloWorld {

    @RequestMapping("/hello")
    public String hello () {
        return "Hello World";
    }
}

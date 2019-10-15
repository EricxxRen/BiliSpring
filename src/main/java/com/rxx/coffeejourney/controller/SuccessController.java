package com.rxx.coffeejourney.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

@Controller
public class SuccessController {

    //查出一些数据在页面展示
    @RequestMapping("/success")
    public String success (Map<String, Object> map) {
        map.put("Hello", "<h1>你好<h1/>");
        map.put("users", Arrays.asList("Eric", "Leo", "Jack"));
        //classpath:/templates/success.html
        return "success";
    }
}

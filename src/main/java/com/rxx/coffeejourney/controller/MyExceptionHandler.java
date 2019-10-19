package com.rxx.coffeejourney.controller;

import com.rxx.coffeejourney.exceptions.UserNotExistException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    //浏览器与客户端都返回json数据，没有自适应功能
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> exceptionHander (Exception e) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("errorcode", "1032");
//        map.put("msg", e.getMessage());
//        map.put("timestamp", System.currentTimeMillis());
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String exceptionHander (Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();

        //传入自己的错误状态码
        //Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        request.setAttribute("javax.servlet.error.status_code", 400);
        map.put("errorcode", "1032");
        map.put("msg", e.getMessage());
        map.put("timestamp", System.currentTimeMillis());

        //将扩展信息放到request中，供MyErrorAttributes类获取
        request.setAttribute("extInfo", map);
        return "forward:/error";
    }
}

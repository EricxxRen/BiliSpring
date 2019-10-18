package com.rxx.coffeejourney.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping(value = "/usr/login")
    public String login (@RequestParam String username,
                         @RequestParam String password,
                         Map<String, Object> map,
                         HttpSession session) {
        if (!StringUtils.isEmpty(username) && "12345".equals(password)) {
            session.setAttribute("loginUser", username);
            //登录成功，为防止表单重复提交，使用重定向到主页
            return "redirect:/main.html";
        } else {
            map.put("msg", "Login Failed!");
            return "login";
        }

    }
}

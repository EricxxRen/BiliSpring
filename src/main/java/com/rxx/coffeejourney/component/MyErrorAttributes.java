package com.rxx.coffeejourney.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company", "google");

        //获取MyExceptionHandler中定义的extInfo
        //第二个参数表示域，0表示从request域，1表示从session域
        Map<String, Object> extInfo = (Map<String, Object>) webRequest.getAttribute("extInfo",0);
        map.put("extInfo", extInfo);
        return map;
    }
}

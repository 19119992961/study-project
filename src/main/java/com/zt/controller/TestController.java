package com.zt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: zt
 * @CreateTime: 2021/5/27 10:36
 * @描述：
 **/
@RestController
@RequestMapping("/sys")
public class TestController {

    @RequestMapping("/test")
    public String test(HttpServletRequest request){
        return "hello";
    }
}

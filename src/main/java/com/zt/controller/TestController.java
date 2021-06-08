package com.zt.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zt.utils.RequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: zt
 * @CreateTime: 2021/5/27 10:36
 * @描述：
 **/
@Api(tags = "TestController",description = "学习项目测试")
@RestController
@RequestMapping("/sys")
public class TestController {

    @RequestMapping("/test")
    @ApiOperation("简单测试")
    public String test(HttpServletRequest request,String word){
        String requestIp = RequestUtil.getRequestIp(request);
        return word+":"+requestIp;
    }
}

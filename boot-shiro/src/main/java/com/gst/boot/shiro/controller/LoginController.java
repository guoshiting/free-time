package com.gst.boot.shiro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);


    @GetMapping
    @ResponseBody
    public Object login(String username,String password){
        logger.info("登录接口开始执行,参数username=>{},password=>{}",username,password);
        return "666666";
    }
}

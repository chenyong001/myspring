package com.cy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope //热更新
public class ConfigController {

    @Value("${userNameTest}")
    private String userNameTest;

    @Value("${userNameShare}")
    private String userNameShare;

    @Value("${userNameExt}")
    private String userNameExt;

    @RequestMapping("/test")
    public String test(){
        System.out.println(userNameTest);
        System.out.println(userNameShare);
        System.out.println(userNameExt);
        return userNameTest;
    }
}

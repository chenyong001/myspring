package com.cy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FeignController {

    @RequestMapping("/test")
    public  String test(){
        log.debug("log debug feign-service test");
        log.info("log info  feign-service test");
        return "test";
    }
    @RequestMapping("/test2")
    public  String test2(){
        log.debug("log debug feign-service test");
        log.info("log info  feign-service test");
        int a=1/0;
        return "test";
    }
    @RequestMapping("/test3")
    public  String test3(){
        log.debug("log debug feign-service test");
        log.info("log info  feign-service test");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "test3";
    }


}

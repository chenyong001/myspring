package com.cy.controller;

import com.cy.feign.FeignTestService;
import com.cy.feign.SentinelFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api")
public class ApiController {
    @Autowired
//    @Qualifier("sentinelFeignService")
    SentinelFeignService sentinelFeignService;
    @Autowired
//    @Qualifier("feignTestService")
    FeignTestService feignTestService;
    @RequestMapping("/test")
    public  String test(){
        log.debug("log debug feign");
        log.info("log info feign");
        System.out.println(sentinelFeignService.test2());
        return sentinelFeignService.test2();
    }

    @RequestMapping("/test2")
    public  String test2(){
        log.debug("log debug feign");
        log.info("log info feign");
        System.out.println(feignTestService.test());
        return feignTestService.test();
    }


}

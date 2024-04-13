package com.cy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * name 服务名
 * path @RequestMapping名字
 */
@FeignClient(name="nacos-service",path = "/feigntest")
//@Qualifier("feignTestService")
public interface FeignTestService {
    @RequestMapping("/test")
//    @RequestLine("GET /test2")
    public String test();
}

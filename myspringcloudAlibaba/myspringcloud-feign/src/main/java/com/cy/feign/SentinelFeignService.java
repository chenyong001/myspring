package com.cy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * name 服务名
 * path @RequestMapping名字
 */
@FeignClient(name="nacos-service",path = "/api",fallback = Test2serviceFallback.class)
//@Qualifier("sentinelFeignService")
public interface SentinelFeignService {
    @RequestMapping("/test")
//    @RequestLine("GET /test2")
    public String test2();
}

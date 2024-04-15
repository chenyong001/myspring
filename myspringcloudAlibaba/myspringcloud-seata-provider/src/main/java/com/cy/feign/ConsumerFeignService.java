package com.cy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * name 服务名
 * path @RequestMapping名字
 */
@FeignClient(name="seata-consumer-cloud-service",path = "/stock",fallback = Test2serviceFallback.class)
//@Qualifier("sentinelFeignService")
public interface ConsumerFeignService {
    @RequestMapping("/reduce")
    public String reduce();
}

package com.cy.feign;

import org.springframework.stereotype.Component;

@Component
public class Test2serviceFallback implements SentinelFeignService{
    @Override
    public String test2() {
        return "feign 降级";
    }
}

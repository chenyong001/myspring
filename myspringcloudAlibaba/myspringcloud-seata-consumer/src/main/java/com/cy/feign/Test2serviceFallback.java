package com.cy.feign;

import org.springframework.stereotype.Component;

@Component
public class Test2serviceFallback implements ConsumerFeignService{
    @Override
    public String add() {
        return "feign 降级";
    }
}

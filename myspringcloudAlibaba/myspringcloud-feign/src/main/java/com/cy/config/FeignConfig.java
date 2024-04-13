package com.cy.config;

import com.cy.interceptor.MyFeignInterceptor;
import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    /**
     * feign 的日志配置
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    /**
     * 修改契约配置，支持feign原生的注解  老版本用@RequestLine，新版本@RequestMapping， 如果项目中用的以前的feign版本，升级后，不想改代码，则注入下面代码，使用@RequestLine
     * @return
     */
//    @Bean
//    public Contract feignContract(){
//        return new Contract.Default();
//    }

    /**
     * feign的连接时间喝超时时间配置
     * @return
     */
    @Bean
    public Request.Options options(){
        return  new Request.Options(5000,10000);
    }
    @Bean
    public MyFeignInterceptor myFeignInterceptor(){
        return  new MyFeignInterceptor();
    }
}

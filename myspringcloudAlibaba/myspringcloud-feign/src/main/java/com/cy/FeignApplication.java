package com.cy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class FeignApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(FeignApplication.class, args);

    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }

//            //方法名一定要叫iRule
//        @Bean
//        public IRule iRule(){
//            //返回一个随机的负载均衡策略
//            return new RandomRule();
//        }
//
//    @Configuration
//    public class RuleConfig {
//
//        //方法名一定要叫iRule
//        @Bean
//        public IRule iRule(){
//            //返回一个随机的负载均衡策略
//            return new RandomRule();
//        }
//    }
}

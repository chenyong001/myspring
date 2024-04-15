package com.cy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.cy.*")
//@MapperScan("com.cy.*")
@SpringBootApplication
@EnableFeignClients
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SeataConsumerCloudApp {
    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(SeataConsumerCloudApp.class, args);
        System.out.println("Hello world!");
    }


}
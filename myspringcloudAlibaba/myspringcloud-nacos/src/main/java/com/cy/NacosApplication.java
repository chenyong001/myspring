package com.cy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@EnableDiscoveryClient
public class NacosApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosApplication.class, args);
        String property = applicationContext.getEnvironment().getProperty("user");
        System.out.println(property);

        System.out.println("Hello world!");
    }

}

package com.cy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.cy.*")
@SpringBootApplication
@EnableFeignClients
public class SeataProviderCloudApp {
    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(SeataProviderCloudApp.class, args);
        System.out.println("Hello world!");
    }


}
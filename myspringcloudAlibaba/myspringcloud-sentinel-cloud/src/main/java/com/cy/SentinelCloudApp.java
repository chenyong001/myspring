package com.cy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SentinelCloudApp {
    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(SentinelCloudApp.class, args);
        System.out.println("Hello world!");
    }


}
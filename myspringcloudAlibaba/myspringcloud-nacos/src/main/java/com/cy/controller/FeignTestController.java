package com.cy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/feigntest")
public class FeignTestController {

    @RequestMapping("/test")
    public  String test(){
        System.out.println("feigntest");
        return "feigntest";
    }


    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 8, 10, TimeUnit.SECONDS
            , new LinkedBlockingQueue<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());


    ThreadLocal<String> threadLocal = new ThreadLocal<>();
    int num;

    public void threadPollTest() {
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {

//                System.out.println("num="+());
                threadLocal.set(++num + " " + Thread.currentThread().getId());
                System.out.println(threadLocal.get());
                threadLocal.remove();
            }
        });
    }

}

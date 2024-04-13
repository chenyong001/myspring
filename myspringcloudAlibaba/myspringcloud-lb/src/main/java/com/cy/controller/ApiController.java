package com.cy.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("/test1")
    public String test1() {
        System.out.println("/api/test1");
//        第一种
//        String url = "http://localhost:9001/test2/api/test2";
        //        第二种
//        List<ServiceInstance> instances = discoveryClient.getInstances("test2-service");
//        ServiceInstance serviceInstance = instances.get(0);
//        String host = serviceInstance.getHost();
//        int port = serviceInstance.getPort();
//        String url2 ="http://"+host+":"+port+"/api/test2";
//        第三种
        String url ="http://nacos-service/api/test";
//        String url ="http://test1-service/test1/api/test";
        String forObject = restTemplate.getForObject(url, String.class);
        System.out.println(forObject);
//        System.out.println("num="+(++num));
//        threadPollTest();

        return "test1";
    }
//    @RequestMapping("/test")
//    public  String test(){
//        System.out.println("test");
//        return "test";
//    }


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

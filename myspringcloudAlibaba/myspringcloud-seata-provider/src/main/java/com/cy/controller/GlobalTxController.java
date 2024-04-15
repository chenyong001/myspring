package com.cy.controller;

import com.cy.domain.Order;
import com.cy.feign.ConsumerFeignService;
import com.cy.service.OrderService;
import io.seata.spring.annotation.GlobalLock;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/order")
@Slf4j
public class GlobalTxController {
    @Resource
    private OrderService orderService;

    @Resource
    private ConsumerFeignService consumerFeignService;

    /**
     * 普通事务处理分布式任务，无法解决回滚问题
     * @return
     */
    @GetMapping("/addGlobal2")
    @GlobalTransactional(rollbackFor = Exception.class)
    public  String addGlobal2(){
        System.out.println("order addGlobal2");
        Order order = new Order();
        order.setName(UUID.randomUUID().toString().replace("-",""));

        orderService.saveOrder(order);

        consumerFeignService.reduce();

        int a=1/0;
        return "order addGlobal2";
    }

    @GetMapping("/addGlobal3")
    public  String addGlobal3(){
        System.out.println("order addGlobal3");
        Order order = new Order();
        order.setName(UUID.randomUUID().toString().replace("-",""));


        orderService.saveOrder2(order);


        return "order addGlobal3";
    }

    @GetMapping("/addGlobal4")
    @GlobalTransactional(rollbackFor = Exception.class)
    @GlobalLock
    public  String addGlobal4(){
        System.out.println("order addGlobal4");
        Order order = new Order();
        order.setName(UUID.randomUUID().toString().replace("-",""));

        orderService.saveOrder(order);

//        consumerFeignService.reduce();

        int a=1/0;
        return "order addGlobal4";
    }


    @GetMapping("/addGlobal5")
    public  String addGlobal5(){
        System.out.println("order addGlobal5");
        Order order = new Order();
        order.setName(UUID.randomUUID().toString().replace("-",""));


        orderService.saveOrder3(order);


        return "order addGlobal5";
    }
}

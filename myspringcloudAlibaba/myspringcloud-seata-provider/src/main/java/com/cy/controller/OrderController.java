package com.cy.controller;

import com.cy.domain.Order;
import com.cy.feign.ConsumerFeignService;
import com.cy.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Resource
    private OrderService orderService;

    @Resource
    private ConsumerFeignService consumerFeignService;

    /**
     * 普通事务处理分布式任务，无法解决回滚问题
     * @return
     */
    @GetMapping("/add")
    public  String add(){
        System.out.println("order add");
        Order order = new Order();
        order.setName(UUID.randomUUID().toString().replace("-",""));
        orderService.saveOrder(order);
        return "order add";
    }

    /**
     * 普通事务处理分布式任务，无法解决回滚问题
     * @return
     */
    @GetMapping("/add2")
    @Transactional(rollbackFor = Exception.class)
    public  String add2(){
        System.out.println("order add2");
        Order order = new Order();
        order.setName(UUID.randomUUID().toString().replace("-",""));
        orderService.saveOrder(order);

        consumerFeignService.reduce();

        int a=1/0;
        return "order add2";
    }

    /**
     * seata 分布式事务框架，默认用AT模式处理分布式任务
     * @return
     */
    @GetMapping("/addGlobal")
    public  String addGlobal(){
        System.out.println("order addGlobal");

        extracted();
        return "order add";
    }



    @GlobalTransactional(rollbackFor = Exception.class)
    public void extracted() {
        Order order = new Order();
        order.setName(UUID.randomUUID().toString().replace("-",""));
        orderService.save(order);

        consumerFeignService.reduce();

        int a=1/0;
    }


    @GetMapping("/test")
    public  String test(){
        System.out.println("order test");
        return "order test";
    }
}

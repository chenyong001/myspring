package com.cy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.domain.Order;
import com.cy.feign.ConsumerFeignService;
import com.cy.mapper.OrderMapper;
import com.cy.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Resource
    private ConsumerFeignService consumerFeignService;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrder(Order order) {
//        this.save(order);
        order.setName("update");
        order.setId(75);
        this.updateById(order);
    }

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public void saveOrder3(Order order) {
        this.save(order);
        int a=1/0;
    }

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public void saveOrder2(Order order) {

        this.baseMapper.insert(order);

        consumerFeignService.reduce();

        int a=1/0;
    }
}

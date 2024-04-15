package com.cy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cy.domain.Order;
import io.seata.spring.annotation.GlobalTransactional;

public interface OrderService extends IService<Order> {

      void saveOrder(Order order);

      @GlobalTransactional(rollbackFor = Exception.class)
      void saveOrder3(Order order);

      void saveOrder2(Order order);
}

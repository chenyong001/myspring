package com.cy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cy.domain.Stock;

public interface StockService extends IService<Stock> {

      boolean updateStock(Stock stock);
      boolean addStock(Stock stock);

      boolean addStock2(Stock stock);
}

package com.cy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.domain.Stock;
import com.cy.mapper.StockMapper;
import com.cy.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements StockService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateStock(Stock stock) {
        this.updateById(stock);
//        int a=1/0;
        return  true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addStock(Stock stock) {
        this.save(stock);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addStock2(Stock stock) {
        this.save(stock);
        int a=1/0;
        return true;
    }
}

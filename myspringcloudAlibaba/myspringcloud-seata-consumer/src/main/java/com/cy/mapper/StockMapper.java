package com.cy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.domain.Stock;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface StockMapper extends BaseMapper<Stock> {
}

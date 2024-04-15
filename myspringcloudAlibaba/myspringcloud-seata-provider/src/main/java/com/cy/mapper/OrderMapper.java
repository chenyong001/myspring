package com.cy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.domain.Order;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}

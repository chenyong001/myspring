package com.cy.controller;

import com.cy.domain.Stock;
import com.cy.feign.ConsumerFeignService;
import com.cy.service.StockService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/stock")
@Slf4j
public class StockController {
    @Resource
    private StockService stockService;
    @Resource
    private ConsumerFeignService consumerFeignService;

    @GetMapping("/reduce")
    public  String reduce(){
        System.out.println("stock reduce");

        int id=1;
        Stock stock1 = stockService.getById(id);
        Stock stock = new Stock();
        stock.setId(id);
        stock.setNum(stock1.getNum()-1);
        stockService.updateStock(stock);

        return "stock reduce";
    }

    @GetMapping("/reduce2")
    @GlobalTransactional(rollbackFor = Exception.class)
    public  String reduce2(){
        System.out.println("stock reduce");

        int id=1;
        Stock stock1 = stockService.getById(id);
        Stock stock = new Stock();
        stock.setId(id);
        stock.setNum(stock1.getNum()-1);
        stockService.updateStock(stock);
        int a=1/0;
        return "stock reduce";
    }

    @GetMapping("/addStock")
    @GlobalTransactional(rollbackFor = Exception.class)
    public  String addStock(){
        System.out.println("stock addStock");

        Stock stock = new Stock();
        stock.setNum(200);
        stockService.addStock(stock);
        int a=1/0;
        return "stock addStock";
    }
    @GetMapping("/addStock2")
    public  String addStock2(){
        System.out.println("stock addStock2");

        Stock stock = new Stock();
        stock.setNum(200);
        stockService.addStock2(stock);
        return "stock addStock2";
    }

    /**
     * 此方法验证到seata的运行流程，
     * 但存在insert无法回滚的问题
     * @return
     */
    @GetMapping("/reduce3")
    @GlobalTransactional(rollbackFor = Exception.class)
    public  String reduce3(){
        System.out.println("stock reduce3");

        int id=1;
        Stock stock1 = stockService.getById(id);
        Stock stock = new Stock();
        stock.setId(id);
        stock.setNum(stock1.getNum()-1);
        stockService.updateStock(stock);

        consumerFeignService.add();
        int a=1/0;
        return "stock reduce3";
    }
    @GetMapping("/test")
    public  String test(){
        System.out.println("order test");
        return "order test";
    }
}

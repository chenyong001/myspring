package com.cy.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/degrade")
@Slf4j
public class SentinelDegradeController {




    /**
     * @SentinelResource    怎么使用？
     * 1、添加依赖 sentinel-annotation-aspectj
     * 2、配置bean new SentinelResourceAspect()
     * 3、value 定义资源
     * blockHandler 设置流控降级后的处理方法，默认要在同一个类中，如果不，需要添加blockHandlerClass,方法 必须是static
     * fallback接口异常处理 和blockHandler同时指定，blockHandler优先级更高
     * @return
     */
    @SentinelResource(value = "test1",blockHandler = "blockHandlerTest1")
    @RequestMapping("/test1")
    public String test1(){
        int a=1/0;

        return "success";
    }


    /**
     * 1、一定要public
     * 2、返回值一定要和原方法一致
     * 3、可以区分是什么规则的BlockException
     * @param e
     * @return
     */
    public String blockHandlerTest1(BlockException e){
        e.printStackTrace();
        log.error("被熔断了");
        return "被熔断了";
    }
    @PostConstruct
    public  void init(){
        List<DegradeRule> ruleList=new ArrayList<>();
        DegradeRule degradeRule = new DegradeRule();
        degradeRule.setResource("test1");
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        degradeRule.setCount(2);
//        一分钟内出现2次异常后熔断，10秒后半开，再次出现异常则直接熔断
        degradeRule.setTimeWindow(10);
        degradeRule.setMinRequestAmount(2);
        degradeRule.setStatIntervalMs(60*1000);
        ruleList.add(degradeRule);
        DegradeRuleManager.loadRules(ruleList);
    }

}

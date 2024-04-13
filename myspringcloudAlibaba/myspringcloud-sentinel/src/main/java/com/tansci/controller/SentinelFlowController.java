package com.tansci.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class SentinelFlowController {


//    @SentinelResource("test4")
    @RequestMapping("test4")
    public String test4(){
       String result="";
        try(Entry entry= SphU.entry("test4")){
            result="SentinelResource===test4";
            log.info(result);
        }
        catch (Exception e){
            result="被流控了哦";
            log.error(result);
        }

        return result;
    }

    /**
     * @SentinelResource    怎么使用？
     * 1、添加依赖 sentinel-annotation-aspectj
     * 2、配置bean new SentinelResourceAspect()
     * 3、value 定义资源
     * blockHandler 设置流控降级后的处理方法，默认要在同一个类中，如果不，需要添加blockHandlerClass,方法 必须是static
     * fallback接口异常处理 和blockHandler同时指定，blockHandler优先级更高
     * @return
     */
    @SentinelResource(value = "test5",blockHandler = "blockHandlerTest5",fallback = "fallbackTest5")
    @RequestMapping("/test5")
    public String test5(){
        int a=1/0;

        return "success";
    }
    public String fallbackTest5(Throwable throwable){

        throwable.printStackTrace();
        return "异常了";
    }

    /**
     * 1、一定要public
     * 2、返回值一定要和原方法一致
     * 3、可以区分是什么规则的BlockException
     * @param e
     * @return
     */
    public String blockHandlerTest5(BlockException e){
        e.printStackTrace();
        log.error("被流控了");
        return "被流控了";
    }
    @PostConstruct
    public  void init(){
        List<FlowRule> ruleList=new ArrayList<>();
        FlowRule flowRule = new FlowRule();
        flowRule.setResource("test4");
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule.setCount(1);
        ruleList.add(flowRule);
//        List<FlowRule> ruleList2=new ArrayList<>();
        FlowRule flowRule2 = new FlowRule();
        flowRule2.setResource("test5");
        flowRule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule2.setCount(1);
        ruleList.add(flowRule2);
        FlowRuleManager.loadRules(ruleList);
    }

}

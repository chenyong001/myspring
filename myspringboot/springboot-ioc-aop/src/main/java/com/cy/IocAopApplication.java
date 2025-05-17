package com.cy;

import com.cy.aop.point.MyFun;
import com.cy.ioc.LifeCycle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IocAopApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(IocAopApplication.class, args);
//        生命周期测试
        LifeCycle lifeCycle = applicationContext.getBean(LifeCycle.class);
        lifeCycle.doBusiness();

        MyFun myFun = applicationContext.getBean(MyFun.class);
//        myFun.fun();
//        myFun.fun3("33","3");
//        System.out.println(myFun.fun4("34", "4"));
//       myFun.fun5("35", "5");
//        MyFun2 myFun2 = applicationContext.getBean(MyFun2.class);
//        myFun2.fun2();
//       导致AOP失效： 1、方法内部调用方法
//        myFun.fun6("36","6");

    }
}

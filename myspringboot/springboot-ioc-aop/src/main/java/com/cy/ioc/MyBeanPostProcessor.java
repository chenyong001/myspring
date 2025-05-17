package com.cy.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
       if(beanName.equalsIgnoreCase("LifeCycle")){
           System.out.println("5.1、postProcessBeforeInitialization方法执行了");
       }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equalsIgnoreCase("LifeCycle")){
            System.out.println("8.1、postProcessAfterInitialization方法执行了");
            System.out.println("aop是ioc的一个扩展功能，在beanpostProcessor的后置方法中进行实现");

        }
        return bean;
    }
}

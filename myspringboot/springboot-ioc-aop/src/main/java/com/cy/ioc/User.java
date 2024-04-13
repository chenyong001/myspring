package com.cy.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class User implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {


    public User() {
        System.out.println("spring Bean 的生命周期");
        System.out.println("1、beanDefinition中获取bean的定义信息");
        System.out.println("2、User的构造方法创建实例");
    }
    private String name;

    public String getName() {
        System.out.println("User的name属性get");
        return name;
    }

    @Value("张3")
    public void setName(String name) {
        System.out.println("3、User的name属性注入");
        this.name = name;
    }
    @Override
    public void setBeanName(String name) {
        System.out.println("4、BeanNameAware的方法执行了");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("5、BeanFactoryAware的方法执行了");
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("6、ApplicationContextAware的方法执行了");
    }
    @PostConstruct
    public  void xx(){
        System.out.println("8、初始化的方法执行了");

    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("9、InitializingBean的方法执行了");
    }


    @PreDestroy
    public  void xx1(){
        System.out.println("11、销毁的方法执行了");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("12、DisposableBean的方法执行了");
    }
}

package com.cy.ioc;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Spring Bean 生命周期完整演示类
 *
 * 生命周期阶段:
 * 1. 实例化(Instantiation)
 * 2. 属性赋值(Populate properties)
 * 3. 初始化(Initialization)
 * 4. 使用(In use)
 * 5. 销毁(Destruction)
 */
@Component
public class LifeCycle implements BeanNameAware, BeanFactoryAware,
        ApplicationContextAware, InitializingBean, DisposableBean {

    @Value("张三")
    private String name;

    public LifeCycle() {
        System.out.println("1. 实例化阶段: 调用构造函数创建Bean实例");
    }

    @Value("张三")
    public void setName(String name) {
        System.out.println("2. 属性赋值阶段: 依赖注入(@Value)");
        this.name = name;
    }

    // ========== Aware接口回调阶段 ==========
    @Override
    public void setBeanName(String name) {
        System.out.println("3. Aware接口回调: BeanNameAware.setBeanName()");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("4. Aware接口回调: BeanFactoryAware.setBeanFactory()");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("5. Aware接口回调: ApplicationContextAware.setApplicationContext()");
    }

    // ========== 初始化前阶段 ==========
    @PostConstruct
    public void initMethod() {
        System.out.println("6. 初始化阶段: @PostConstruct方法执行");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("7. 初始化阶段: InitializingBean.afterPropertiesSet()");
    }

    public void customInit() {
        System.out.println("8. 初始化阶段: 自定义init-method方法(如果有配置)");
    }

    // ========== 初始化后阶段 ==========
    // 注意: 实际BeanPostProcessor应该在单独的类中实现
    // 这里仅为演示生命周期顺序

    // ========== 使用阶段 ==========
    public void doBusiness() {
        System.out.println("9. 使用阶段: Bean业务方法执行");
    }

    // ========== 销毁阶段 ==========
    @PreDestroy
    public void preDestroy() {
        System.out.println("10. 销毁阶段: @PreDestroy方法执行");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("11. 销毁阶段: DisposableBean.destroy()");
    }

    public void customDestroy() {
        System.out.println("12. 销毁阶段: 自定义destroy-method方法(如果有配置)");
    }
}

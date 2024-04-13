package com.cy.designModel.proxy.jdk_proxy;


import com.cy.designModel.proxy.static_proxy.SellTickets;

/**
 * java中的代理，按照代理类的生成时机又分为静态代理和动态代理，静态代理是在编译器生成，动态代理是在运行时生成
 * jdk动态代理示列，只需要更换ProxyFactory类中 Class clazz=Air.class; 在运行时动态绑定代理执行对应业务
 * 必须被代理类实现接口
 */
public class Client {
    public static void main(String[] args) {
    ProxyFactory proxy = new ProxyFactory();
        SellTickets proxy1 = proxy.getProxy();
        proxy1.sell();
    }
}

package com.cy.designModel.proxy.static_proxy;

/**
 * 静态代理示列
 * java中的代理，按照代理类的生成时机又分为静态代理和动态代理，静态代理是在编译器生成，动态代理是在运行时生成
 */
public class Client {
    public static void main(String[] args) {
        ProxyFactory proxy = new ProxyFactory();
        proxy.sell();
    }
}

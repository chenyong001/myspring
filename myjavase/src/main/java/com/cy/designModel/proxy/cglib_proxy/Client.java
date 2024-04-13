package com.cy.designModel.proxy.cglib_proxy;




/**
 * java中的代理，按照代理类的生成时机又分为静态代理和动态代理，静态代理是在编译器生成，动态代理是在运行时生成
 * cglib动态代理示列， 在运行时动态绑定代理执行对应业务
 * 不需要被代理类实现接口
 */
public class Client {
    public static void main(String[] args) {
   ProxyFactory proxy = new ProxyFactory();
        Transtation proxy1 = proxy.getProxy();
        proxy1.sell();
    }
}

package com.cy.designModel.proxy.static_proxy;

public class ProxyFactory implements SellTickets {
    private Transtation transtation=new Transtation();


    @Override
    public void sell() {
        System.out.println("代理点售票");
        transtation.sell();
    }
}

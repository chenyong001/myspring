package com.cy.designModel.proxy.static_proxy;

public class Transtation implements SellTickets{
    @Override
    public void sell() {
        System.out.println("火车站售票");
    }
}

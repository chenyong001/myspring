package com.cy.designModel.proxy.jdk_proxy;

import com.cy.designModel.proxy.static_proxy.SellTickets;

public class Transtation implements SellTickets {
    @Override
    public void sell() {
        System.out.println("火车站售票");
    }
}

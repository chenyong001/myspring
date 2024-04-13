package com.cy.designModel.proxy.jdk_proxy;

import com.cy.designModel.proxy.static_proxy.SellTickets;

public class Air implements SellTickets {
    @Override
    public void sell() {
        System.out.println("航空站售票");
    }
}

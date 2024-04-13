package com.cy.designModel.observe;

import java.util.Observable;
import java.util.Observer;

public class PoliceMan implements Observer {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name+":警察抓住小偷:"+((Theif)o).getName());
    }
}

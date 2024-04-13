package com.cy.designModel.observe;

import java.util.Observable;

public class Theif extends Observable {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void steal(){
        System.out.println(name+"：偷东西了");
        super.setChanged();
        super.notifyObservers();
    }
}

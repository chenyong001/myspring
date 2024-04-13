package com.cy.designModel.observe;

import java.util.HashMap;

//观察者模式
public class Client {
    public static void main(String[] args) {
//        Theif theif = new Theif();
//        theif.setName("张三");
//
//        PoliceMan  policeMan1= new PoliceMan();
//        policeMan1.setName("王台");
//        PoliceMan  policeMan2= new PoliceMan();
//        policeMan2.setName("陈项羽");
//
//        theif.addObserver(policeMan1);
//        theif.addObserver(policeMan2);
//
//        theif.steal();

        HashMap<String, String> stringStringHashMap = new HashMap<>(5);
        System.out.println(stringStringHashMap.size());
        stringStringHashMap.put("1","1");
        stringStringHashMap.put("2","2");
        stringStringHashMap.put("3","3");
        stringStringHashMap.put("4","4");
        stringStringHashMap.put("5","5");
        stringStringHashMap.put("6","6");
    }
}

package com.cy.newInstance;

public class Parent {
    public static  String parentStaticName="父类的静态变量";
    static {
        System.out.println("父类的静态代码块");
    }
    public static  String parentPutongName="父类的普通变量";

    {
        System.out.println("父类的普通代码块");
    }
    public Parent(){
        System.out.println("父类的构造方法");
    }
}

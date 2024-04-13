package com.cy.designModel.singleton;

/**
 * 饿汉式
 */
public class Singleton1 {
    private static Singleton1 singleton1 = new Singleton1();

    private Singleton1() {
//        防止反射破坏单列
        if(singleton1!=null){
            throw new RuntimeException();
        }
    }

    public static Singleton1 getInstance() {
        return singleton1;
    }

//    可以防止反序列化破坏单列
    public Object readResolve(){
        return singleton1;
    }

}

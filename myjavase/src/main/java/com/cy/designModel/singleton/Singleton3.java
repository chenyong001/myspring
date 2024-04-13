package com.cy.designModel.singleton;

/**
 * 懒汉式 线程安全 性能下降
 */
public class Singleton3 {
    private static Singleton3 singleton3;

    private Singleton3() {
    }

    public static synchronized  Singleton3 getInstance() {
        if(singleton3==null){
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}

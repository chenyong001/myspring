package com.cy.designModel.singleton;

/**
 * 饿汉式 静态代码块
 */
public class Singleton2 {
    private static Singleton2 singleton2;
    static {
        singleton2 = new Singleton2();
    }

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return singleton2;
    }
}

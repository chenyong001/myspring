package com.cy.designModel.singleton;

/**
 * 懒汉式 线程安全 双重检查锁 调整加锁时机
 */
public class Singleton4 {
    //    防止指令重排
    private static volatile Singleton4 singleton4;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (singleton4 == null) {
            synchronized (Singleton4.class) {
                singleton4 = new Singleton4();
            }
        }
        return singleton4;
    }
}

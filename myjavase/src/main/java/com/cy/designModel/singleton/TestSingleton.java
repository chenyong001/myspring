package com.cy.designModel.singleton;

public class TestSingleton {


    public static void main(String[] args) {
        Singleton1 singleton1=Singleton1.getInstance();
        Singleton1 singleton2=Singleton1.getInstance();
        System.out.println(singleton1==singleton2);
        Singleton2 singleton21=Singleton2.getInstance();
        Singleton2 singleton22=Singleton2.getInstance();
        System.out.println(singleton21==singleton22);
        Singleton3 singleton31=Singleton3.getInstance();
        Singleton3 singleton32=Singleton3.getInstance();
        System.out.println(singleton31==singleton32);
        Singleton4 singleton41=Singleton4.getInstance();
        Singleton4 singleton42=Singleton4.getInstance();
        System.out.println(singleton41==singleton42);
        Singleton5 singleton51=Singleton5.getInstance();
        Singleton5 singleton52=Singleton5.getInstance();
        System.out.println(singleton51==singleton52);
        Singleton6 singleton61=Singleton6.INSTANCE;
        Singleton6 singleton62=Singleton6.INSTANCE;
        System.out.println(singleton61==singleton62);


//       反序列化和反射能破坏单列
//        readResolve()方法可以防止反序列化破坏


    }

}

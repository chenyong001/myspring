package com.cy.newInstance;

/**
 * 1、java中初始化对象的过程？new Test（）
 * 初始化过程是这样的：
 * 1.首先，初始化父类中的静态成员变量和静态代码块，按照在程序中出现的顺序初始化；
 * 2.然后，初始化子类中的静态成员变量和静态代码块，按照在程序中出现的顺序初始化；
 * 3.其次，初始化父类的普通成员变量和代码块，在执行父类的构造方法；
 * 4.最后，初始化子类的普通成员变量和代码块，在执行子类的构造方法；
 * 总结：父静-子静-父普通-父构造-子普通-子构造
 */
public class Child extends Parent {
    public static  String parentStaticName="子类的静态变量";
    static {
        System.out.println("子类的静态代码块");
    }
    public static  String parentPutongName="子类的普通变量";

    {
        System.out.println("子类的普通代码块");
    }
    public Child(){
        System.out.println("子类的构造方法");
    }

    public static void main(String[] args) {
        new Child();
    }

}

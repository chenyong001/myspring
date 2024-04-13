package com.cy.aop.point;

import org.springframework.stereotype.Service;

@Service
public class MyFun {

    public  void fun(){
        System.out.println("com.cy.spring.aop.Test1===fun()");
    }
    public  void fun3(String id ,String name){
        System.out.println("com.cy.spring.aop.Test1===fun3()");
    }
    public  String fun4(String id ,String name){
        System.out.println("com.cy.spring.aop.Test1===fun4()");
        return "result";
    }
    public  String fun5(String id ,String name){
        System.out.println("com.cy.spring.aop.Test1===fun5()");
        throw new RuntimeException();
    }
    public  void fun6(String id ,String name){
        System.out.println("com.cy.spring.aop.Test1===fun6()");
        fun();
    }
}

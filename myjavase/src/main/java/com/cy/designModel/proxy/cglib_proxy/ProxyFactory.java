package com.cy.designModel.proxy.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory {



    public  Transtation getProxy() {
//        创建Enhancer 对象，
        Enhancer enhancer=new Enhancer();
//        设置父类的字节码对象
        enhancer.setSuperclass(Transtation.class);
//        设置回调函数
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib--执行了");
                method.invoke(Transtation.class.newInstance(),objects);
                return null;
            }
        });
//        创建代理对象
        Transtation transtation = (Transtation)enhancer.create();
        return transtation;
    }
}

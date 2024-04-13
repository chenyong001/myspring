package com.cy.designModel.proxy.jdk_proxy;

import com.cy.designModel.proxy.static_proxy.SellTickets;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {



    public  SellTickets getProxy() {

//        Class clazz=Transtation.class;
        Class clazz=Air.class;
        SellTickets proxy=  (SellTickets)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {
            /**
             *
             * @param proxy the proxy instance that the method was invoked on
             *
             * @param method the {@code Method} instance corresponding to
             * the interface method invoked on the proxy instance.  The declaring
             * class of the {@code Method} object will be the interface that
             * the method was declared in, which may be a superinterface of the
             * proxy interface that the proxy class inherits the method through.
             *
             * @param args an array of objects containing the values of the
             * arguments passed in the method invocation on the proxy instance,
             * or {@code null} if interface method takes no arguments.
             * Arguments of primitive types are wrapped in instances of the
             * appropriate primitive wrapper class, such as
             * {@code java.lang.Integer} or {@code java.lang.Boolean}.
             *
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("jdk代理点售票");
                /**
                 * Params:
                 * obj – the object the underlying method is invoked from args – the arguments used for the method call
                 * Returns:
                 * the result of dispatching the method represented by this object on obj with parameters args
                 */
                method.invoke(clazz.newInstance(),args);
                return null;
            }
        });
        return proxy;
    }
}

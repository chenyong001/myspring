package com.cy.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAop {

    /**
     * 切入点表达式的格式：
     * execution([可见性] 返回类型 [声明类型].方法名(参数) [异常])
     * 其中【】中的为可选，其他的还支持通配符的使用:
     * *：匹配所有字符
     * ..：一般用于匹配多个包，多个参数
     * +：表示类及其子类
     * 运算符有：&&、||、!
     */
    @Pointcut("execution(* com.cy.aop.point..*.*(..))")
    public void myPointCut() {
    }

    @Before("myPointCut()")
    public void before() {
        System.out.println("MyAop====before");
    }

    @Around("myPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        String methodName = ((MethodSignature) joinPoint.getSignature()).getMethod().getName();
        System.out.println("MyAop====around====before=methodName="+methodName);
        Object object;
        try {
            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {
                System.out.println(arg);
            }
            object = joinPoint.proceed(args);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println("MyAop====around====after==object="+object);

        return "around return";
    }

    @After("myPointCut()")
    public void after() {
        System.out.println("MyAop====after");
    }

    @AfterReturning("myPointCut()")
    public Object afterReturning(){
        System.out.println("MyAop====afterReturning");
        return "around afterReturning";
    }

    @AfterThrowing(value = "myPointCut()",throwing = "e")
    public Object afterthowing(JoinPoint joinPoint,Throwable e){
            System.out.println("MyAop====afterthowing===e="+e);
        return "around afterthowing";
    }


}

//package com.test.aop;
//
//import com.test.db.DB;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//
//
//@Aspect
//@Component
//public class ParamsValideAop {
//
//    @Pointcut("execution(* com.test.controller..*.*(..))")
//    public void myPointCut() {
//    }
//
//    @Around("myPointCut()")
//    public Object around(ProceedingJoinPoint joinPoint) {
//        String methodName = ((MethodSignature) joinPoint.getSignature()).getMethod().getName();
//        System.out.println("MyAop====around====before=methodName=" + methodName);
//        Object object;
//        try {
//            Object[] args = joinPoint.getArgs();
//            for (Object arg : args) {
//                System.out.println(arg);
//                if (!DB.concurrentHashMap.containsKey(arg)) {
////                        接口增加校验，限制key只能传配置项中内容。
//                    throw new RuntimeException("参数限制key只能传配置项中内容");
//                }
//
//            }
//            object = joinPoint.proceed(args);
//        } catch (Throwable e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("MyAop====around====after==object=" + object);
//
//        return object;
//    }
//
//
//}

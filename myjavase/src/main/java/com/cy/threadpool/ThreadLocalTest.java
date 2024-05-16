package com.cy.threadpool;

import com.alibaba.ttl.TransmittableThreadLocal;

public class ThreadLocalTest {

//    https://blog.csdn.net/A434534658/article/details/134512614
    private static final TransmittableThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();

    public static void main(String[] args) {
        // 在主线程中设置变量
        threadLocal.set("MainThreadVariable");

        // 创建并启动子线程
        Thread childThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 在子线程中获取变量
                String variable = threadLocal.get();
                System.out.println("Child thread got variable: " + variable);
            }
        });
        childThread.start();
    }
}

package com.cy.threadpool;

import java.util.concurrent.atomic.AtomicInteger;

public class CASExample {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        // 创建两个线程，分别进行增加操作
        Thread thread1 = new Thread(new IncrementTask());
        Thread thread2 = new Thread(new IncrementTask());

        // 启动线程
        thread1.start();
        thread2.start();

        // 等待线程执行完成
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印最终结果
        System.out.println("Counter: " + counter.get());
    }

    static class IncrementTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                int oldValue;
                int newValue;

                do {
                    // 获取当前的值
                    oldValue = counter.get();
                    // 计算新值
                    newValue = oldValue + 1;
                    // 使用CAS尝试更新值
                } while (!counter.compareAndSet(oldValue, newValue));
            }
        }
    }
}

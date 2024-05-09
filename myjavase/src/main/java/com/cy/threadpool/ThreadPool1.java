package com.cy.threadpool;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * 1、java线程池如何合理配置核心线程数？
 *
 * 线程池合理的线程数你是如何考虑的？这也是之前面试遇到的一个题：
 *
 * 1.先看下机器的CPU核数，然后在设定具体参数：
 * System.out.println(Runtime.getRuntime().availableProcessors());
 * 即CPU核数 = Runtime.getRuntime().availableProcessors()
 *
 * 2.分析下线程池处理的程序是CPU密集型，还是IO密集型
 * CPU密集型：核心线程数 = CPU核数 + 1
 * IO密集型：核心线程数 = CPU核数 * 2
 *
 * 注：IO密集型（某大厂实践经验）
 *        核心线程数 = CPU核数 / （1-阻塞系数）     例如阻塞系数 0.8，CPU核数为4
 *        则核心线程数为20
 */
public class ThreadPool1 {

    public static void main(String[] args) {
        // 创建一个线程池对象
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 5, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        // 提交多个任务到线程池中
        for (int i = 1; i <= 10; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " is running");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // 关闭线程池
        executor.shutdown();
        while (!executor.isTerminated()) {

        }
        System.out.println("线程池完全关闭");
    }

    @Test
    public void countDownLatch() {
        System.out.println("test1");
        // 创建一个线程池对象
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 5, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        int tasks = 10;
        CountDownLatch countDownLatch = new CountDownLatch(tasks);

        // 提交多个任务到线程池中
        for (int i = 1; i <= tasks; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " is running");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 关闭线程池
        executor.shutdown();
        System.out.println("线程池完全关闭");

    }


    @Test
    public void completableFuture() {
        System.out.println("test2");
        System.out.println(Runtime.getRuntime().availableProcessors());

        int nThreads = 10;
        // 创建一个线程池对象
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                25, 25, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        CompletableFuture<?>[] futures = new CompletableFuture[nThreads];

        for (int i = 0; i < nThreads; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " is running");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, executor);
            futures[i] = future;
        }

        // 等待所有线程执行完毕
        CompletableFuture.allOf(futures).join();
        // 关闭线程池
        executor.shutdown();
        System.out.println("线程池完全关闭");

    }
}

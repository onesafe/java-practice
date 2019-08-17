package com._onesafe.designpatten.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 测试多线程环境下各种创建单例模式的效率
 */
public class MultiThreadTest {

    public static void main(String[] args) throws Exception {
        timeEhan();
        timeLanhan();
        timeInnerClass();
        timeEnum();
    }

    private static void timeEhan() throws Exception {
        long start = System.currentTimeMillis();
        int threadNum = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        for (int i=0; i<threadNum; i++) {
            new Thread(() -> {
                for (int j=0; j<1000000; j++) {
                    Object o = EhanSingleton.getInstance();
                }
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await(); // main线程阻塞，直到计数器为0，才会继续往下执行

        long end = System.currentTimeMillis();
        System.out.println("饿汉式总耗时: " + (end - start));
    }

    private static void timeLanhan() throws Exception {
        long start = System.currentTimeMillis();
        int threadNum = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        for (int i=0; i<threadNum; i++) {
            new Thread(() -> {
                for (int j=0; j<1000000; j++) {
                    Object o = LanhanSingleton.getInstance();
                }
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await(); // main线程阻塞，直到计数器为0，才会继续往下执行

        long end = System.currentTimeMillis();
        System.out.println("懒汉式总耗时: " + (end - start));
    }

    private static void timeInnerClass() throws Exception {
        long start = System.currentTimeMillis();
        int threadNum = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        for (int i=0; i<threadNum; i++) {
            new Thread(() -> {
                for (int j=0; j<1000000; j++) {
                    Object o = InnerClassSingleton.getInstance();
                }
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await(); // main线程阻塞，直到计数器为0，才会继续往下执行

        long end = System.currentTimeMillis();
        System.out.println("静态内部类总耗时: " + (end - start));
    }

    private static void timeEnum() throws Exception {
        long start = System.currentTimeMillis();
        int threadNum = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        for (int i=0; i<threadNum; i++) {
            new Thread(() -> {
                for (int j=0; j<1000000; j++) {
                    Object o = EnumSingleton.getInstance();
                }
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await(); // main线程阻塞，直到计数器为0，才会继续往下执行

        long end = System.currentTimeMillis();
        System.out.println("枚举内部类总耗时: " + (end - start));
    }
}

// 奇怪，根据我多次测试的结果，懒汉式的耗时是最低的

/*
饿汉式总耗时: 208
懒汉式总耗时: 54
静态内部类总耗时: 106
枚举内部类总耗时: 82
 */
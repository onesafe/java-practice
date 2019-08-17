package com._onesafe.designpatten.singleton.multitest;

import com._onesafe.designpatten.singleton.LanhanSingleton;

import java.util.concurrent.CountDownLatch;

public class MultiThreadLanhanTest {

    public static void main(String[] args) throws Exception {
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
}

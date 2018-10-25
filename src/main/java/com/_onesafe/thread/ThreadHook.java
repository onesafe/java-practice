package com._onesafe.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by onesafe on 25/10/2018.
 */
public class ThreadHook {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("The hook thread 1 is running.");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("The hook thread 1 will exit.");
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("The hook thread 2 is running.");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("The hook thread 2 will exit.");
            }
        });

        System.out.println("The program is stopping..");
    }
}

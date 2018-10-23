package com._onesafe.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by onesafe on 23/10/2018.
 */
public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() ->
        {
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Oh, i am be interrupted. ");
            }
        });

        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();
    }
}

package com._onesafe.threadlocal;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;

/**
 * Created by onesafe on 28/09/2018.
 */
public class ThreadLocalExample {

    public static void main(String[] args) {

        final ThreadLocal<Integer> tlocal = new ThreadLocal<>();

        IntStream.range(0, 10).forEach(
                i -> new Thread(
                () -> {
                    try {
                        tlocal.set(i);
                        System.out.println(currentThread() + " set i " + tlocal.get());

                        TimeUnit.SECONDS.sleep(1);

                        System.out.println(currentThread() + " get i " + tlocal.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            ).start()
        );
    }
}

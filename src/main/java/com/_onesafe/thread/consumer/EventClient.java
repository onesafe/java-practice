package com._onesafe.thread.consumer;

import java.util.concurrent.TimeUnit;

/**
 * Created by onesafe on 24/10/2018.
 */
public class EventClient {

    public static void main(String[] args) {
        final EventQueue eventQueue = new EventQueue();

        new Thread(() ->
        {
            for(;;) {
                eventQueue.offer(new EventQueue.Event());
            }
        }, "Producer").start();

        new Thread(() ->
        {
            for(;;) {
                eventQueue.take();
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer").start();
    }
}

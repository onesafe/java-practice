package com._onesafe.eventBus;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by onesafe on 02/11/2018.
 */
public class AsyncEventBusTest {

    // Async
    public static void main(String[] args) {
        Bus bus = new AsyncEventBus("TestBus", (ThreadPoolExecutor) Executors.newFixedThreadPool(10));
        bus.register(new SimpleSubscriber1());
        bus.register(new SimpleSubscriber2());
        bus.post("hello");
        System.out.println("-----------");
        bus.post("Hello", "test");
    }
}

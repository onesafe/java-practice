package com._onesafe.eventBus;


/**
 * Created by onesafe on 02/11/2018.
 */
public class EventBusTest {

    public static void main(String[] args) {
        Bus bus = new EventBus("TestBus");
        bus.register(new SimpleSubscriber1());
        bus.register(new SimpleSubscriber2());
        bus.post("hello");
        System.out.println("-----------");
        bus.post("Hello", "test");
    }
}

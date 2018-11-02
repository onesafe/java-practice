package com._onesafe.eventBus;

/**
 * Created by onesafe on 02/11/2018.
 */
public class SimpleObject {

    @Subscribe(topic = "alex-topic")
    public void test2(Integer x) {

    }

    @Subscribe(topic = "test-topic")
    public void test3(Integer x) {

    }
}

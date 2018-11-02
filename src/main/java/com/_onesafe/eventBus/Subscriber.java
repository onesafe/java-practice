package com._onesafe.eventBus;

import lombok.Data;

import java.lang.reflect.Method;

/**
 * Created by onesafe on 02/11/2018.
 */
@Data
public class Subscriber {

    private final Object subscribeObject;

    private final Method subscribeMethod;

    private boolean disable = false;

    public Subscriber(Object subscribeObject, Method subscribeMethod) {
        this.subscribeMethod = subscribeMethod;
        this.subscribeObject = subscribeObject;
    }
}

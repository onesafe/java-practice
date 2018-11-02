package com._onesafe.eventBus;

import java.lang.reflect.Method;

/**
 * Created by onesafe on 02/11/2018.
 */
public interface EventContext {

    String getSource();

    Object getSubscriber();

    Method getSubscribe();

    Object getEvent();
}

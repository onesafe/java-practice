package com._onesafe.eventBus;

/**
 * Created by onesafe on 02/11/2018.
 */
public interface EventExceptionHandler {

    void handle(Throwable cause, EventContext context);
}

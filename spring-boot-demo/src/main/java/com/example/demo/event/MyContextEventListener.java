package com.example.demo.event;

import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by onesafe on 05/09/2019 8:33 PM.
 */
public class MyContextEventListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof ApplicationStartingEvent) {
            System.out.println("[Event] ------ ApplicationStartingEvent");
        } else if (applicationEvent instanceof ApplicationEnvironmentPreparedEvent) {
            System.out.println("[Event] ------ ApplicationEnvironmentPreparedEvent");
        } else if (applicationEvent instanceof ApplicationPreparedEvent) {
            System.out.println("[Event] ------ ApplicationPreparedEvent");
        } else if (applicationEvent instanceof ApplicationStartedEvent) {
            System.out.println("[Event] ------ ApplicationStartedEvent");
        } else if (applicationEvent instanceof ApplicationReadyEvent) {
            System.out.println("[Event] ------ ApplicationReadyEvent");
        } else if (applicationEvent instanceof ApplicationFailedEvent) {
            System.out.println("[Event] ------ ApplicationFailedEvent");
        }
    }
}

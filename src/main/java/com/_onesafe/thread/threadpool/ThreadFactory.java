package com._onesafe.thread.threadpool;

/**
 * Created by onesafe on 25/10/2018.
 */
@FunctionalInterface
public interface ThreadFactory {

    Thread createThread(Runnable runnable);
}

package com._onesafe.thread.threadpool;

/**
 * Created by onesafe on 25/10/2018.
 */
public interface ThreadPool {

    void execute(Runnable runnable);

    void shutdown();

    int getInitSize();

    int getMaxSize();

    int getCoreSize();

    int getQueueSize();

    int getActiveCount();

    boolean isShutdown();
}

package com._onesafe.thread.threadpool;

/**
 * Created by onesafe on 25/10/2018.
 */
public interface RunnableQueue {


    void offer(Runnable runnable);

    Runnable take();

    int size();
}

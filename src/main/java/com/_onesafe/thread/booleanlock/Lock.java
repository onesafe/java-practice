package com._onesafe.thread.booleanlock;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * Created by onesafe on 25/10/2018.
 */
public interface Lock {

    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeoutException;

    void unlock();

    List<Thread> getBlockedThreads();
}

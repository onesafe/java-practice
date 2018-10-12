package com._onesafe.latch;

import java.util.concurrent.TimeUnit;

/**
 * Created by onesafe on 12/10/2018.
 */
public abstract class Latch {

    protected int limit;

    public Latch(int limit) {
        this.limit = limit;
    }

    public abstract void await(TimeUnit unit, long time) throws InterruptedException, WaitTimeoutException;

    public abstract void countDown();

    public abstract int getUnarrived();
}

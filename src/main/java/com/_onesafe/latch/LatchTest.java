package com._onesafe.latch;

import java.util.concurrent.TimeUnit;

/**
 * Created by onesafe on 12/10/2018.
 */
public class LatchTest {
    public static void main(String[] args) throws InterruptedException, WaitTimeoutException {
        Latch latch = new CountDownLatch(4);

        new ProgrammerTravel(latch, "Alex", "Bus").start();
        new ProgrammerTravel(latch, "Gavin", "Walking").start();
        new ProgrammerTravel(latch, "Jack", "Subway").start();
        new ProgrammerTravel(latch, "Dillon", "Bicycle").start();

        latch.await(TimeUnit.SECONDS, 5);
        System.out.println("== all of programmer arrived ==");
    }
}

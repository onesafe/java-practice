package com._onesafe.future;

import java.util.concurrent.Callable;

/**
 * Created by onesafe on 22/10/2018.
 */
public class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程正在进行计算");
        Thread.sleep(3000);
        int sum = 0;

        for(int i=0; i<100; i++){
            sum += i;
        }
        return sum;
    }
}

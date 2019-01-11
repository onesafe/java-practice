package com._onesafe.zk.curator;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangyiping on 11/01/2019.
 */
public class client {

    public static void main(String args[]) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0;i<4;i++){
            service.execute(()-> {
                DistLock test = new DistLock();
                try {
                    test.lock("predictor", "xxx123456");
                    TimeUnit.SECONDS.sleep(25);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("i am going to release lock...");
                try {
                    test.unlock("predictor", "xxx123456");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        service.shutdown();
    }
}

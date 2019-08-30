package concurrent;

import java.util.concurrent.*;

/**
 * Created by onesafe on 30/08/2019 5:25 PM.
 */
public class CallableTest {

    public static void main(String[] args) throws Exception {

        // 定义一个Callable任务
        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 1243;
            } catch (InterruptedException e) {
                throw new IllegalArgumentException("task interrupted", e);
            }
        };


        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);
        System.out.println("future done? " + future.isDone());

        Integer result = future.get(5, TimeUnit.SECONDS);

        System.out.println("future done? " + future.isDone());
        System.out.println("result: " + result);


        // 关闭线程池
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            // 指定关闭之前的等待时间 5s，达到“温柔滴”关闭
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.out.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}

package concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by onesafe on 30/08/2019 5:43 PM.
 */
public class ScheduledExecutorTest {

    public static void main(String[] args) throws Exception {
        schedule3();
    }

    private static void schedule1() throws Exception {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(1337);

        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms\n", remainingDelay);

    }


    private static void schedule2() throws Exception {
        ScheduledExecutorService executor1 = Executors.newScheduledThreadPool(1);
        Runnable task1 = () -> System.out.println("Scheduling: " + System.nanoTime());

        // 第一次执行的延迟时间
        int initialDelay = 0;
        // 周期频率
        int period = 1;
        // 指定任务立刻执行，且每次之间间隔为 1s
        executor1.scheduleAtFixedRate(task1, initialDelay, period, TimeUnit.SECONDS);
    }


    /**
     * scheduleWithFixedDelay() 和 scheduleAtFixedRate() 最大的区别就是，
     * scheduleWithFixedDelay()需要等到前一个任务执行完成后才开始计延时，再触发下一个任务。
     * @throws Exception e
     */
    private static void schedule3() throws Exception {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling: " + System.nanoTime());
            }
            catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        };

        executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
    }
}

package concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by onesafe on 30/08/2019 5:38 PM.
 */
public class InvokeAllTest {

    public static void main(String[] args) throws Exception {

        // Executors.newWorkStealingPool()。这个工厂方法是 Java8 才引入的，
        // 返回值是一个 ForkJoinPool类型的 executor，它和指定固定大小的线程池不同，
        // ForkJoinPools 允许指定一个并行因子来创建，默认的值为物理机可用的 CPU 核心数。
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3");


        executor.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        // 拿到每个 future 的返回值
                        return future.get();
                    }
                    catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println); // for 循环输出结果
    }
}

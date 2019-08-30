package feature;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by onesafe on 30/08/2019 3:15 PM.
 */
public class ParallelStreamsTest {

    int max = 1000000;
    List<String> values = new ArrayList<>(max);

    private void initValue() {
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
    }

    private void signalStream() {

        initValue();

        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("顺序流排序耗时: %d ms", millis));
    }


    private void parallelStream() {

        initValue();

        long t0 = System.nanoTime();
        long count = values.parallelStream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("并行流排序耗时: %d ms", millis));
    }

    public static void main(String[] args) {
        ParallelStreamsTest p = new ParallelStreamsTest();
        //p.signalStream();
        p.parallelStream();
    }

    /*
    并行流排序耗时: 578 ms
    顺序流排序耗时: 985 ms
     */
}

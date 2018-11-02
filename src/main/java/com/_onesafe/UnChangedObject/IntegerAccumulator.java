package com._onesafe.UnChangedObject;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by onesafe on 02/11/2018.
 *
 * ##### 不可变对象设计模式 #####
 *
 * 不可变对象最核心的地方在于不给外部修改共享资源的机会，这样就会避免多线程情况下的数据冲突
 * 而导致的数据不一致的情况，又能避免因为对锁的依赖而带来的性能降低
 */
public final class IntegerAccumulator {

    private final int init;

    private IntegerAccumulator(int init) {
        this.init = init;
    }

    private IntegerAccumulator(IntegerAccumulator accumulator, int init) {
        this.init = accumulator.getValue() + init;
    }

    private IntegerAccumulator add(int i) {
        return new IntegerAccumulator(this, i);
    }

    private int getValue() {
        return this.init;
    }

    private static void slowly() {
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IntegerAccumulator accumulator = new IntegerAccumulator(0);
        IntStream.range(0, 3).forEach(i -> new Thread(() ->
        {
            int inc = 0;
            while (inc < 10) {
                int oldValue = accumulator.getValue();
                int result = accumulator.add(inc).getValue();

                System.out.println(oldValue + " + " + inc + " = " + result);
                if (inc + oldValue != result) {
                    System.out.println("ERROR: " + oldValue + " + " + inc + " = " + result);
                }
                inc++;
                slowly();
            }
        }).start());
    }
}

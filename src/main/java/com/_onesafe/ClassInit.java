package com._onesafe;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by onesafe on 26/10/2018.
 */
public class ClassInit {

    static {
        try {
            System.out.println("The ClassInit static code block will be invoke.");
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IntStream.range(1, 6).forEach(i -> new Thread(ClassInit::new));
    }
}

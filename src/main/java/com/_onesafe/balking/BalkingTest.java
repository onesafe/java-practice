package com._onesafe.balking;

/**
 * Created by onesafe on 08/10/2018.
 */
public class BalkingTest {

    public static void main(String[] args) {
        new DocumentEditThread("/Users/onesafe/Documents/code", "balking.txt").start();
    }
}

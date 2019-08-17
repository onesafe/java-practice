package com._onesafe.designpatten.state;

/**
 * 已入住状态
 */
public class CheckedInState implements State {
    @Override
    public void handle() {
        System.out.println("房间已人住。请勿打扰！！！");
    }
}

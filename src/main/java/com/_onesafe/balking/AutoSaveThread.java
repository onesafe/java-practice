package com._onesafe.balking;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by onesafe on 08/10/2018.
 */
public class AutoSaveThread extends Thread {

    private final Document document;

    public AutoSaveThread(Document document) {
        super("DocumentAutoSaveThread");
        this.document = document;
    }

    @Override
    public void run() {
        while(true) {
            try {
                document.save();
                TimeUnit.SECONDS.sleep(1);
            } catch (IOException | InterruptedException e) {
                break;
            }
        }
    }
}

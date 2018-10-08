package com._onesafe.balking;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by onesafe on 08/10/2018.
 */
public class DocumentEditThread extends Thread {

    private final String documentPath;

    private final String documemntName;

    private final Scanner scanner = new Scanner(System.in);

    public DocumentEditThread(String documentPath, String documemntName) {
        super("DocumentEditThread");
        this.documentPath = documentPath;
        this.documemntName = documemntName;
    }

    @Override
    public void run() {
        int times = 0;

        try {
            Document document = Document.create(documentPath, documemntName);
            while(true) {
                String text = scanner.next();
                if("quit".equals(text)) {
                    document.close();
                    break;
                }

                document.edit(text);

                if(times == 5) {
                    document.save();
                    times = 0;
                }
                times++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

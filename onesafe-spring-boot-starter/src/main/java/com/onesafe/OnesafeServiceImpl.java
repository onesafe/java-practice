package com.onesafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by onesafe on 02/09/2019 6:16 PM.
 */
public class OnesafeServiceImpl implements OnesafeService {


    @Value("${test.value}")
    private String onesafeTest;

    @Autowired
    private OnesafeServiceProperties onesafeServiceProperties;

    @Override
    public void say() {
        String message = onesafeServiceProperties.getMessage();
        System.out.println("Onesafe Say: " + message);

        System.out.println("Onesafe Test: " + onesafeTest);
    }
}

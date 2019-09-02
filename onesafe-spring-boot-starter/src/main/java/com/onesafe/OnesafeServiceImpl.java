package com.onesafe;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by onesafe on 02/09/2019 6:16 PM.
 */
public class OnesafeServiceImpl implements OnesafeService {

    @Autowired
    private OnesafeServiceProperties onesafeServiceProperties;

    @Override
    public void say() {
        String message = onesafeServiceProperties.getMessage();
        System.out.println("Onesafe Say: " + message);
    }
}

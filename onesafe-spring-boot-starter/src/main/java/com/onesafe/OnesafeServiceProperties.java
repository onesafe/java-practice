package com.onesafe;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by onesafe on 02/09/2019 6:14 PM.
 */
@ConfigurationProperties(prefix = "spring.onesafe")
public class OnesafeServiceProperties {

    /** 默认输出 */
    private String message = "Hi, good morning";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

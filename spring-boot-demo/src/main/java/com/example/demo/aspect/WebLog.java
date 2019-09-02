package com.example.demo.aspect;

import java.lang.annotation.*;

/**
 * Created by onesafe on 02/09/2019 11:59 AM.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface WebLog {

    /**
     * 日志描述信息
     * @return desc
     */
    String description() default "";
}

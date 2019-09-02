package com.example.demo.controller;

import com.example.demo.aspect.WebLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by onesafe on 02/09/2019 12:06 PM.
 */
@RestController
public class AopController {

    @GetMapping("/aop")
    @WebLog(description = "你好，AOP!")
    public String aop() {
        return "Hello, AOP !";
    }
}

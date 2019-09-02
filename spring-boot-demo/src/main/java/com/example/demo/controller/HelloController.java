package com.example.demo.controller;

import com.onesafe.OnesafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by onesafe on 02/09/2019 10:42 AM.
 */
@RestController
public class HelloController {

    @Autowired
    private OnesafeService onesafeService;

    @GetMapping("/hello")
    public String hello() {
        onesafeService.say();
        return "Hello, Spring Boot !";
    }
}

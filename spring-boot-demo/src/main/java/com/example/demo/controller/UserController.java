package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by onesafe on 02/09/2019 2:30 PM.
 */
@RestController
public class UserController {

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        System.out.println(user.getCreateTime().toString());

        // 将 user 再以 Json 的形式返回
      return user;
    }
}

/*
Jackson 是 Spring Boot 内置的 Json 解析框架，用来完成出入参的序列化和反序列化。
通常，我们会在 Controller 类中方法上，加上 @RequestBody 或者 @ResponseBody 注解，
Spring Boot 会自动对出入参做 Json 解析与转换工作。
 */
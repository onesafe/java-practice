package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by onesafe on 02/09/2019 2:16 PM.
 */
@Configuration
public class CORSConfig extends WebMvcConfigurationSupport {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://www.baidu.com")
                .allowedMethods("POST", "GET");
    }
}

/*
跨域访问的原理其实很简单，当发起跨域请求的时候，浏览器会对请求域返回的 HTTP 头进行检查，
如果 Access-Control-Allow-Origin 包含了自身域，则表示允许访问，否者报错。这也正是上述代码中 allowedOrigins() 方法的作用。
 */
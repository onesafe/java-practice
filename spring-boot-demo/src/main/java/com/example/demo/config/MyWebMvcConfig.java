package com.example.demo.config;

import com.example.demo.interceptor.LoginValidationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by onesafe on 02/09/2019 2:59 PM.
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        InterceptorRegistration registration = interceptorRegistry.addInterceptor(new LoginValidationInterceptor());
        registration.addPathPatterns("/**");
        registration.excludePathPatterns("/static/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://www.baidu.com")
                .allowedMethods("POST", "GET");
    }
}

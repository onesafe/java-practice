package com.onesafe;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by onesafe on 02/09/2019 6:18 PM.
 */
@Configuration
@ConditionalOnClass(OnesafeService.class)
@EnableConfigurationProperties(OnesafeServiceProperties.class)
public class OnesafeAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public OnesafeService onesafeService() {
        return new OnesafeServiceImpl();
    }
}

/*

    @Configuration: 标注类为一个配置类，让 spring 去扫描它；
    @ConditionalOnClass：条件注解，只有在 classpath 路径下存在指定 class 文件时，才会实例化 Bean；
    @EnableConfigurationProperties：使指定配置类生效；
    @Bean: 创建一个实例类注入到 Spring Ioc 容器中；
    @ConditionalOnMissingBean：条件注解，意思是，仅当 Ioc 容器不存在指定类型的 Bean 时，才会创建 Bean。

 */
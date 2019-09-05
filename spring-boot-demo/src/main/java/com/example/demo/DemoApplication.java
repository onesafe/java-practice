package com.example.demo;

import com.example.demo.event.MyContextEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplicationBuilder(DemoApplication.class)
				.listeners(new MyContextEventListener())
				.registerShutdownHook(true)
				.build();

		app.run(args);
	}

}
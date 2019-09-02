package com.example.demo;

import com.example.demo.kafka.KafkaProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private KafkaProvider kafkaProducer;

	@Test
	public void sendMessage() throws InterruptedException {

		for (int i=0; i<1000; i++) {
			long orderId = i+1;
			String orderNum = UUID.randomUUID().toString();
			kafkaProducer.sendMessage(orderId, orderNum, LocalDateTime.now());
		}

		TimeUnit.MINUTES.sleep(1);
	}

}

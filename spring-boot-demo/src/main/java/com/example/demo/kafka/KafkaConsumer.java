package com.example.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by onesafe on 02/09/2019 5:20 PM.
 */
@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = {"test", "haha"}, groupId = "group_id")
    public void consume(String message) {
        log.info("## consume message: {}", message);
    }
}

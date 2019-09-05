package com.example.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * Created by onesafe on 02/09/2019 5:20 PM.
 */
//@Component // 不使用kafka的时候，注释掉，以免影响服务启动
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = {"test", "haha"}, groupId = "group_id")
    public void consume(String message) {
        log.info("## consume message: {}", message);
    }
}

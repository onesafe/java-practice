package com.example.demo.kafka;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;

/**
 * Created by onesafe on 02/09/2019 5:14 PM.
 */
//@Component  // 不使用kafka的时候，注释掉，以免影响服务启动
@Slf4j
public class KafkaProvider {

    private static final String TOPIC = "test";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(long orderId, String orderNum, LocalDateTime createTime) {

        // 构建一个订单
        Order order = Order.builder()
                .orderId(orderId)
                .orderNum(orderNum)
                .createTime(createTime)
                .build();

        // 发送消息，订单类的 json 作为消息体
        ListenableFuture<SendResult<String, String>> futrure = kafkaTemplate.send(TOPIC, JSONObject.toJSONString(order));

        // 监听回调
        futrure.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.info("## Send message fail ...");
            }

            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                log.info("## Send message success ...");
            }
        });
    }
}

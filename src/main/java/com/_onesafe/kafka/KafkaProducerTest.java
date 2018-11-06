package com._onesafe.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * Created by onesafe on 06/11/2018.
 */
public class KafkaProducerTest implements Runnable {

    private final KafkaProducer<String, String> producer;
    private final String topic;

    public KafkaProducerTest(String topicName) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        this.producer = new KafkaProducer<String, String>(props);
        this.topic = topicName;
    }

    @Override
    public void run() {
        int messageNo = 1;
        try {
            for(;;) {
                String messageStr = "你好，这是第" + messageNo + "条数据";
                producer.send(new ProducerRecord<String, String>(topic, "Message", messageStr));

                if(messageNo % 100 == 0) {
                    System.out.println("发送的消息：" + messageStr);
                }

                if(messageNo % 10000 == 0) {
                    System.out.println("成功发送了" + messageNo + "条");
                    break;
                }
                messageNo++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }

    public static void main(String[] args) {
        new Thread(new KafkaProducerTest("KAFKA_TEST")).start();
    }
}

package com._onesafe.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by onesafe on 06/11/2018.
 */
public class KafkaConsumerTest implements Runnable {

    private final KafkaConsumer<String, String> consumer;

    private ConsumerRecords<String, String> msgList;

    private final String topic;

    private static final String GROUPID = "groupA";

    public KafkaConsumerTest(String topicName) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("group.id", GROUPID);
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("auto.offset.reset", "earliest");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        this.consumer = new KafkaConsumer<String, String>(props);
        this.topic = topicName;
        this.consumer.subscribe(Arrays.asList(topic));
    }

    @Override
    public void run() {
        int messageNo = 1;
        System.out.println("---------------开始消费-------------");
        try {
            for(;;) {
                msgList = consumer.poll(1000);
                if(null != msgList && msgList.count() > 0) {
                    for (ConsumerRecord<String, String> record : msgList) {

                        if (messageNo % 100 == 0) {
                            System.out.println(messageNo + "============receive: key " + record.key() + ", value = "
                            + record.value() + " offset=============" + record.offset());
                        }

                        if (messageNo % 1000 == 0) {
                            break;
                        }
                        messageNo++;
                    }
                } else {
                    TimeUnit.SECONDS.sleep(1);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }


    public static void main(String[] args) {
        new Thread(new KafkaConsumerTest("KAFKA_TEST")).start();
    }
}

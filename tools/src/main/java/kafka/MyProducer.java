package kafka;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;


/**
 * Created by onesafe on 29/08/2019 5:53 PM.
 * kafka0.9客户端都以record为一条消息，进行发送，record包含一个键值对，分区和topic名。
 * key像map中的key，只是一条record的一个传递属性，可有可无，你可以灵活的使用它，也可不使用
 */
public class MyProducer {
    private static KafkaProducer<String, String> producer;

    static {
        Properties kfkProperties = new Properties();
        kfkProperties.put("bootstrap.servers", "172.27.129.72:9092");
        kfkProperties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        kfkProperties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<String, String>(kfkProperties);
    }

    /**
     *  producer1 发送消息不考虑返回信息
     */
    private static void sendMessageForgotResult() {
        ProducerRecord<String, String> record = new ProducerRecord<>("kafkatest", "name", "ForgetResult");
        producer.send(record);
        producer.close();
    }

    /**
     * producer2 发送消息同步等到发送成功
     */
    private static void sendMessageSync() throws Exception {
        ProducerRecord<String,String> record = new ProducerRecord<>("kafkatest","name","Sync");
        RecordMetadata result = producer.send(record).get();
        System.out.println("时间戳，主题，分区，位移: " + result.timestamp() + "," + record.topic() + "," + result.partition() + "," + result.offset());
        producer.close();
    }

    /**
     * producer3 发送消息异步回调返回消息
     */
    private static void sendMessageCallBack() {
        ProducerRecord<String,String> record;
        while(true) {
            record= new ProducerRecord<>("kafkatest","name","CallBack");
            producer.send(record,new MyProducerCallBack());
            try{
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //producer.close();
    }

    private static class MyProducerCallBack implements Callback {

        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
            if(null != e){
                e.printStackTrace();
                return;
            }
            System.out.println("时间戳，主题，分区，位移: " + recordMetadata.timestamp() + ", " + recordMetadata.topic() + "," + recordMetadata.partition() + " " + recordMetadata.offset());
        }
    }

    public static void main(String[] args) throws Exception {
        //MyProducer.sendMessageCallBack();
        //MyProducer.sendMessageForgotResult();
        MyProducer.sendMessageSync();
    }

}
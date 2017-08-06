package com.illy.kafkatest.controller;

import com.illy.kafkatest.kafka.KafkaProducer;
import com.illy.kafkatest.kafka.MessageStorage;
import com.illy.kafkatest.kafka.multi.NotificationConsumerGroup;
import com.illy.kafkatest.kafka.multi.NotificationProducerThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/kafka")
public class KafkaRestController {

    @Autowired
    KafkaProducer producer;

    @Autowired
    MessageStorage storage;

    @GetMapping(value="/producer")
    public String producer(@RequestParam("data")String data){
        producer.send(data);

        return "Done";
    }

    @GetMapping(value="/consumer")
    public String getAllRecievedMessage(){
        String messages = storage.toString();
        //storage.clear();
        return messages;
    }

    @RequestMapping("/run")
    public void runKafkaThread(){
        String brokers = "localhost:9092";
        String groupId = "test";
        String topic = "test";
        int numberOfConsumer = 3;

        // Start Notification Producer Thread
        NotificationProducerThread producerThread = new NotificationProducerThread(brokers, topic);
        Thread t1 = new Thread(producerThread);
        t1.start();

        // Start group of Notification Consumers
        NotificationConsumerGroup consumerGroup =
                new NotificationConsumerGroup(brokers, groupId, topic, numberOfConsumer);

        consumerGroup.execute();

        try {
            Thread.sleep(100000);
        } catch (InterruptedException ie) {

        }
    }

}

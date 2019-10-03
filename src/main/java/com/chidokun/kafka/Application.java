package com.chidokun.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class Application {

    private static Logger logger = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @KafkaListener(topics = "UMChangePhone")
    public void consumeTopic(ConsumerRecord<?, ?> record) {
        logger.info("Kafka Consumer: {}: {}", record.topic(), record.value());
    }

}

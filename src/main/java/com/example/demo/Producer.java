package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
public class Producer {

    @Autowired
    KafkaTemplate<String, String> template;

    Integer counter = 0;

    @Scheduled(fixedRate = 3000)
    public void produce() {
        counter++;
//        template.executeInTransaction(kt -> kt.send("test", counter.toString(), LocalDateTime.now().toString()));
        template.send("test", counter.toString(), LocalDateTime.now().toString());
    }

}

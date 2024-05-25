package com.apico.usermanangement.service;

import com.apico.usermanangement.wrapper.JournalWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class UserMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> template;

    @Value("${kafka.topic.name}")
    private String topicName;

    public void publishUserEvent(JournalWrapper journalWrapper) {
        log.debug("publishing journal event to topic with id:: {}", journalWrapper.getUserId());
        CompletableFuture<SendResult<String, Object>> future = template.send(topicName, journalWrapper);
        future.whenComplete((result, exception) -> {
           if(Optional.ofNullable(exception).isPresent()){
               log.error("Unable to publish message with user id:: {}, Error Message:: {}", journalWrapper.getUserId(), exception.getMessage());
           }
           else {
               log.debug("Successfully published message with user id:: {}, with offset:: {}", journalWrapper.getUserId(), result.getRecordMetadata().offset());
           }
        });
    }
}

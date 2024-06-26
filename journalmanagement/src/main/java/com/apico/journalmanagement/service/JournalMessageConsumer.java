package com.apico.journalmanagement.service;

import com.apico.journalmanagement.dao.JournalRepository;
import com.apico.journalmanagement.model.Journal;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.apico.journalmanagement.util.JournalManagementUtility.parseJournal;

@Slf4j
@Service
public class JournalMessageConsumer {

    @Autowired
    JournalRepository journalRepository;

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    @Operation(method = "createJournalRecord", description = "Consumes the messages from kafka topic and adds them to the database.")
    public void createJournalRecord(String journalMessage) throws JsonProcessingException {
        Journal journalFromMessage = parseJournal(journalMessage);
        log.debug("Consuming record:: {}", journalFromMessage);
        journalRepository.save(journalFromMessage);
        log.debug("Added Journal to database, with id:: {}", journalFromMessage.getId());
    }
}

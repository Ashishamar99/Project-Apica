package com.apico.journalmanagement.util;

import com.apico.journalmanagement.model.Journal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JournalManagementUtility {
    public static Journal parseJournal(String jsonString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, Journal.class);
    }
}

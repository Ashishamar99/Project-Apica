package com.apico.journalmanagement.service;

import com.apico.journalmanagement.JournalType;
import com.apico.journalmanagement.dao.JournalRepository;
import com.apico.journalmanagement.model.Journal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class JournalService {

    @Autowired
    JournalRepository journalRepository;

    public static List<Journal> journals = new ArrayList<>();

    public List<Journal> getAllPublicJournals() {
        return journalRepository.findByJournalType(JournalType.REGISTRATION);
    }

    public List<Journal> getAllJournals() {
        return journalRepository.findAll();
    }
}

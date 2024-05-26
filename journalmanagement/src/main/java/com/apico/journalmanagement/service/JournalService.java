package com.apico.journalmanagement.service;

import com.apico.journalmanagement.JournalType;
import com.apico.journalmanagement.model.Journal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class JournalService {

    public static List<Journal> journals = new ArrayList<>();

    public List<Journal> getAllPublicJournals() {
        return journals.stream()
                .filter(journal -> journal.getJournalType().equals(JournalType.REGISTRATION))
                .toList();
    }

    public List<Journal> getAllJournals() {
        return journals;
    }
}

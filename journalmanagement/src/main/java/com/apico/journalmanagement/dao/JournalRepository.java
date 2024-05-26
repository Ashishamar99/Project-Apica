package com.apico.journalmanagement.dao;

import com.apico.journalmanagement.JournalType;
import com.apico.journalmanagement.model.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {
    List<Journal> findByJournalType(JournalType journalType);
}

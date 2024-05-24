package com.apico.journalmanagement.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Journal {
    private String id;
    private String userId;
    private String message;
}

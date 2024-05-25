package com.apico.usermanangement.wrapper;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import static com.apico.usermanangement.constants.UserManagementConstants.JOURNAL_TYPE;

@Slf4j
@Builder
@Data
public class JournalWrapper {
    private String userId;
    private String message;
    private JOURNAL_TYPE journalType;
}

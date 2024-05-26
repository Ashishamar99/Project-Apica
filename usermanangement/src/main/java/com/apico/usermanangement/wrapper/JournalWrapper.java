package com.apico.usermanangement.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.apico.usermanangement.constants.UserManagementConstants.JOURNAL_TYPE;

@Slf4j
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JournalWrapper {
    private String userId;
    private String message;
    private JOURNAL_TYPE journalType;
}

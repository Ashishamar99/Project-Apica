package com.apico.usermanangement.constants;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class UserManagementConstants {
    public static final String USER_REGISTRATION_MESSAGE = "User %s is Registered.";
    public enum JOURNAL_TYPE {REGISTRATION, UPDATION, DELETION }
    public static final String SERVICE = "service";

}

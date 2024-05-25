package com.apico.usermanangement.constants;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class UserManagementConstants {
    public static String USER_REGISTRATION_MESSAGE = "User %s is Registered.";
    public static enum JOURNAL_TYPE { RESISTRATION, UPDATION, DELETION };

}

package com.apico.usermanangement.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class User {
    private String id;
    private String username;
    private String password;
    private String mailId;
    private String phNo;
}

package com.apico.usermanangement.service;

import com.apico.usermanangement.model.User;
import com.apico.usermanangement.wrapper.JournalWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static com.apico.usermanangement.constants.UserManagementConstants.JOURNAL_TYPE;
import static com.apico.usermanangement.constants.UserManagementConstants.USER_REGISTRATION_MESSAGE;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserMessagePublisher userMessagePublisher;

    List<User> users = new ArrayList<>();

    public User registerUser(User user) {
        log.debug("inside register user service with id:: {}", user.getId());
        users.add(user);
        userMessagePublisher.publishUserEvent(JournalWrapper.builder()
                        .userId(user.getId())
                        .journalType(JOURNAL_TYPE.RESISTRATION)
                        .message(String.format(USER_REGISTRATION_MESSAGE, user.getId()))
                .build());
        return user;
    }

    public User getUserById(String userId) {
        return users
                .stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with given id:: " + userId));
    }
}

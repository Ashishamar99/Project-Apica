package com.apico.usermanangement.service;

import com.apico.usermanangement.dao.UserManagementRepository;
import com.apico.usermanangement.model.User;
import com.apico.usermanangement.wrapper.JournalWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.apico.usermanangement.constants.UserManagementConstants.JOURNAL_TYPE;
import static com.apico.usermanangement.constants.UserManagementConstants.USER_REGISTRATION_MESSAGE;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserMessagePublisher userMessagePublisher;

    @Autowired
    UserManagementRepository userManagementRepository;

    public User registerUser(User user) {
        log.debug("inside register user service with id:: {}", user.getId());
        User createdUser = userManagementRepository.save(user);
        userMessagePublisher.publishUserEvent(JournalWrapper.builder()
                        .userId(String.valueOf(createdUser.getId()))
                        .journalType(JOURNAL_TYPE.REGISTRATION)
                        .message(String.format(USER_REGISTRATION_MESSAGE, createdUser.getId()))
                .build());
        return createdUser;
    }

    public User getUserById(String userId) {
        return userManagementRepository
                .findById(userId)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with given id:: " + userId));
    }

    public List<User> getAllUsers() {
        return userManagementRepository.findAll();
    }
}

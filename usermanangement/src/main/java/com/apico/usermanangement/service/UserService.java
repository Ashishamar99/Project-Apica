package com.apico.usermanangement.service;

import com.apico.usermanangement.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserService {

    List<User> users = new ArrayList<>();

    public User registerUser(User user) {
        log.debug("inside register user service with id:: {}", user.getId());
        users.add(user);
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

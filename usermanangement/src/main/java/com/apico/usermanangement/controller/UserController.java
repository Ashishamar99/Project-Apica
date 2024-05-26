package com.apico.usermanangement.controller;

import com.apico.usermanangement.model.User;
import com.apico.usermanangement.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("${api.rootpath}")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    @Operation(description = "Sends a string just to test if end points of this server are reachable or not.")
    @ApiResponse(responseCode = "200")
    public String testUserService(){
        return "Hello from user management system";
    }

    @PostMapping(path = "${api.registeruserpath}")
    @Operation(description = "Creates the user from the given information and returns the registered user object.")
    @ApiResponse(responseCode = "201")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Accepts user entitiy in the request body.")
    public ResponseEntity<User> registerUser(@Valid @RequestBody User user){
        log.debug("inside register user function with:: {}", user);
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }

    @GetMapping(path = "${api.getuserfromidpath}")
    @Operation(summary = "Returns the user with the given id", description = "user with given id must exist, else returns 404 not found.")
    @ApiResponses({
            @ApiResponse(responseCode = "302", description = "User is found with given id."),
            @ApiResponse(responseCode = "404", description = "User is not found with given id.")
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Accepts the id of the user to find.")
    public ResponseEntity<User> getUserById(@RequestParam(name = "id") String userId){
        log.debug("inside get user by id function with:: {}", userId);
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.FOUND);
    }

    @GetMapping(path = "${api.getAllUsers}")
    @Operation(description = "Fetches all the users if role is admin. Else throws a forbidden exception.")
    @ApiResponse(responseCode = "200")
    //TODO:: Accept the role in the header in the form of JWT token.
    public List<User> getAllJournals(){
        return userService.getAllUsers();
    }
}

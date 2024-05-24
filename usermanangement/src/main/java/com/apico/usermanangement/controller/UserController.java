package com.apico.usermanangement.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @GetMapping(path = "${api.rootpath}")
    @ApiResponse(description = "Sends a string just to test if end points of this server are reachable or not.")
    public String testUserService(){
        return "Hello from user management system";
    }

}

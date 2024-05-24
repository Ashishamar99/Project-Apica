package com.apico.journalmanagement.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class JournalController {

    @GetMapping(path = "${api.rootpath}")
    @ApiResponse(description = "Sends a string just to test if end points of this server are reachable or not.")
    public String testJournalService(){
        return "Hello from journal service";
    }
}

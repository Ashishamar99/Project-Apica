package com.apico.journalmanagement.controller;

import com.apico.journalmanagement.model.Journal;
import com.apico.journalmanagement.service.JournalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("${api.rootpath}")
public class JournalController {

    @Autowired
    JournalService journalService;

    @GetMapping
    @Operation(description = "Sends a string just to test if end points of this server are reachable or not.")
    @ApiResponse(responseCode = "200")
    public String testJournalService(){
        return "Hello from journal service";
    }

    @GetMapping(path = "${api.getPublicJournals}")
    @Operation(description = "Gets all the journals which do not need a specific role to view.")
    @ApiResponse(responseCode = "200")
    public List<Journal> getAllPublicJournals(){
        return journalService.getAllPublicJournals();
    }

    @GetMapping(path = "${api.getAllJournals}")
    @Operation(description = "Fetches all the journals if role is admin. Else throws a forbidden exception.")
    @ApiResponse(responseCode = "200")
    //TODO:: Accept the role in the header in the form of JWT token.
    public List<Journal> getAllJournals(){
        return journalService.getAllJournals();
    }
}

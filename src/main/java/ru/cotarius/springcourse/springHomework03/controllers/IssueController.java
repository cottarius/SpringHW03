package ru.cotarius.springcourse.springHomework03.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.cotarius.springcourse.springHomework03.model.Issue;
import ru.cotarius.springcourse.springHomework03.services.IssueService;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/issue")
@Slf4j
public class IssueController {
    private IssueService issueService;

    @Autowired
    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping
    public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest issueRequest) {
        log.info("Поступил запрос на выдачу: readerId={}, bookId={}",
                issueRequest.getReaderId(),
                issueRequest.getBookId());

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(issueService.createIssue(issueRequest));
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }
}

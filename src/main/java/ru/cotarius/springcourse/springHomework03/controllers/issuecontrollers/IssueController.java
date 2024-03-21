package ru.cotarius.springcourse.springHomework03.controllers.issuecontrollers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cotarius.springcourse.springHomework03.controllers.dto.IssueRequest;
import ru.cotarius.springcourse.springHomework03.exceptions.BookHasBeenReturnedException;
import ru.cotarius.springcourse.springHomework03.exceptions.AllreadyHaveBook;
import ru.cotarius.springcourse.springHomework03.exceptions.MoreThanAllowedBooksException;
import ru.cotarius.springcourse.springHomework03.model.Issue;
import ru.cotarius.springcourse.springHomework03.services.IssueService;

import java.util.List;
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

    @PutMapping("{id}")
    public ResponseEntity<Issue> returnIssue(@PathVariable long id){
        log.info("Поступил запрос на возврат книги в библиотеку");

        try {
            return ResponseEntity.status(HttpStatus.OK).body(issueService.returnIssue(id));
        } catch (BookHasBeenReturnedException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Issue>> getAllIssues(){
        log.info("Поступил запрос на информацию обо всех выдачах");

        try {
            return ResponseEntity.status(HttpStatus.OK).body(issueService.getAllIssues());
        } catch (NullPointerException e){
            return ResponseEntity.notFound().build();
        }
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
        } catch (AllreadyHaveBook | MoreThanAllowedBooksException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<Issue> getIssueById(@PathVariable long id){
        log.info("Поступил запрос на информаци о выдаче ");

        try {
            return ResponseEntity.status(HttpStatus.OK).body(issueService.getIssueById(id));
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }
}

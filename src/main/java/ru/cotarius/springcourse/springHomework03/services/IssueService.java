package ru.cotarius.springcourse.springHomework03.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.cotarius.springcourse.springHomework03.controllers.IssueRequest;
import ru.cotarius.springcourse.springHomework03.model.Issue;
import ru.cotarius.springcourse.springHomework03.repository.BookRepository;
import ru.cotarius.springcourse.springHomework03.repository.IssueRepository;
import ru.cotarius.springcourse.springHomework03.repository.ReaderRepository;

import java.util.NoSuchElementException;


@RequiredArgsConstructor
@Slf4j
@Service
public class IssueService {
    private final BookRepository bookRepository;
    private final IssueRepository issueRepository;
    private final ReaderRepository readerRepository;

    public Issue createIssue(IssueRequest issueRequest){
        if(bookRepository.getById(issueRequest.getBookId()) == null){
            log.info("Не удалось найти книгу: " + issueRequest.getBookId());
            throw new NoSuchElementException("Не удалось найти книгу: " + issueRequest.getBookId());
        }
        if(readerRepository.getById(issueRequest.getReaderId()) == null){
            log.info("Не удалось найти читателя: " + issueRequest.getReaderId());
            throw new NoSuchElementException("Не удалось найти читателя: " + issueRequest.getReaderId());
        }

        Issue issue = new Issue(issueRequest.getBookId(), issueRequest.getReaderId());
        issueRepository.createIssue(issue);
        return issue;
    }
}

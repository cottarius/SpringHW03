package ru.cotarius.springcourse.springHomework03.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.cotarius.springcourse.springHomework03.controllers.IssueRequest;
import ru.cotarius.springcourse.springHomework03.exceptions.BookHasBeenReturnedException;
import ru.cotarius.springcourse.springHomework03.exceptions.AllreadyHaveBook;
import ru.cotarius.springcourse.springHomework03.model.Issue;
import ru.cotarius.springcourse.springHomework03.repository.BookRepository;
import ru.cotarius.springcourse.springHomework03.repository.IssueRepository;
import ru.cotarius.springcourse.springHomework03.repository.ReaderRepository;

import java.util.List;
import java.util.NoSuchElementException;


@RequiredArgsConstructor
@Slf4j
@Service
public class IssueService {
    private final BookRepository bookRepository;
    private final IssueRepository issueRepository;
    private final ReaderRepository readerRepository;

    /**
     * Возрат книги в библиотеку
     * @param id id выдачи для изменения статуса возрата
     * @return выдыча с изменённым статусом
     */
    public Issue returnIssue(long id){
        if(issueRepository.getById(id).getReturned_at() == null) {
            return issueRepository.returnIssue(id);
        }
        throw new BookHasBeenReturnedException("Книга с id:" +
                issueRepository.getById(id).getBookId() +
                " уже была возвращена");
    }
    public Issue createIssue(IssueRequest issueRequest){
        if(bookRepository.getById(issueRequest.getBookId()) == null){
            log.info("Не удалось найти книгу: " + issueRequest.getBookId());
            throw new NoSuchElementException("Не удалось найти книгу: " + issueRequest.getBookId());
        }
        if(readerRepository.getById(issueRequest.getReaderId()) == null){
            log.info("Не удалось найти читателя: " + issueRequest.getReaderId());
            throw new NoSuchElementException("Не удалось найти читателя: " + issueRequest.getReaderId());
        }
        if(issueRepository.check(issueRequest.getReaderId())){
            log.info("У читателя {} уже есть на руках книга!", issueRequest.getReaderId());
            throw new AllreadyHaveBook("У читателя " + issueRequest.getReaderId() + "уже есть на руках книга!");
        }

        Issue issue = new Issue(issueRequest.getBookId(), issueRequest.getReaderId());
        issueRepository.createIssue(issue);
        return issue;
    }
    public Issue getIssueById(long id){
        return issueRepository.getById(id);
    }
    public List<Issue> getAllIssues(){
        return issueRepository.getAllIssues();
    }
}

package ru.cotarius.springcourse.springHomework03.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.cotarius.springcourse.springHomework03.model.Issue;
import ru.cotarius.springcourse.springHomework03.model.Reader;
import ru.cotarius.springcourse.springHomework03.repository.IssueRepository;
import ru.cotarius.springcourse.springHomework03.repository.ReaderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    public Reader createReader(String firstName, String lastName) {
        Reader reader = new Reader(firstName, lastName);
        readerRepository.addReader(reader);
        return reader;
    }

    public Reader getReaderById(long id) {
       return readerRepository.getById(id);
    }

    public List<Reader> getAllReaders() {
        return readerRepository.getAllReaders();
    }

    public boolean deleteReader(long id) {
        Reader reader = readerRepository.getById(id);
        return readerRepository.deleteReader(reader);
    }

    /**
     * Список всех выдачей для одного читателя
     * @param id id читателя
     * @return
     */
    public List<Issue> getIssuesForReader(long id){
        return issueRepository.getAllIssues()
                .stream()
                .filter(issue -> issue.getReaderId() == id)
                .collect(Collectors.toList());
    }
}

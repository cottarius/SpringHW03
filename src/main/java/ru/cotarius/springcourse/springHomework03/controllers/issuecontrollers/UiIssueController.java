package ru.cotarius.springcourse.springHomework03.controllers.issuecontrollers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.cotarius.springcourse.springHomework03.model.Book;
import ru.cotarius.springcourse.springHomework03.model.Issue;
import ru.cotarius.springcourse.springHomework03.model.Reader;
import ru.cotarius.springcourse.springHomework03.services.BookService;
import ru.cotarius.springcourse.springHomework03.services.IssueService;
import ru.cotarius.springcourse.springHomework03.services.ReaderService;

import java.util.List;

@Controller
@RequestMapping("/ui")
@Slf4j
public class UiIssueController {
    private final IssueService issueService;

    @Autowired
    public UiIssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping("/issues")
    public String getAllIssues(Model model){
        List<Issue> issues = issueService.getAllIssues();
        model.addAttribute("issues", issues);
        return "all-issues";
    }
    @GetMapping("/reader/{id}")
    public String getAllBookByReaderId(@PathVariable Long id, Model model){
        Reader reader = issueService.getReader(id);
        List<Book> books = issueService.booksThatReaderHas(reader);
        model.addAttribute("reader", reader);
        model.addAttribute("books", books);
        return "books-from-reader";
    }
}

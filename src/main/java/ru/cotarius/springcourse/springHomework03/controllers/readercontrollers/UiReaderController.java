package ru.cotarius.springcourse.springHomework03.controllers.readercontrollers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.cotarius.springcourse.springHomework03.model.Book;
import ru.cotarius.springcourse.springHomework03.model.Reader;
import ru.cotarius.springcourse.springHomework03.services.BookService;
import ru.cotarius.springcourse.springHomework03.services.ReaderService;

import java.util.List;

@Controller
@RequestMapping("/ui")
@Slf4j
public class UiReaderController {

    private final ReaderService readerService;

    @Autowired
    public UiReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping("/readers")
    public String getAllBooks(Model model){
        List<Reader> readers = readerService.getAllReaders();
        model.addAttribute("readers", readers);
        return "all-readers";
    }
}

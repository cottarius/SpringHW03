package ru.cotarius.springcourse.springHomework03.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.cotarius.springcourse.springHomework03.model.Book;
import ru.cotarius.springcourse.springHomework03.repository.BookRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book createBook(String name){
        Book book = new Book(name);
        bookRepository.addBook(book);
        return book;
    }
    public Book getBookById(long id){
        List<Book> bookList = bookRepository.getAllBooks();
        return bookList.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }
    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }
}


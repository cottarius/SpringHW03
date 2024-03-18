package ru.cotarius.springcourse.springHomework03.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.cotarius.springcourse.springHomework03.model.Book;
import ru.cotarius.springcourse.springHomework03.repository.BookRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book createBook(String name) {
        Book book = new Book(name);
        bookRepository.addBook(book);
        return book;
    }

    public Book getBookById(long id) {
        return bookRepository.getById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public boolean deleteBook(long id) {
        Book book = bookRepository.getById(id);
        return bookRepository.deleteBook(book);

    }
}


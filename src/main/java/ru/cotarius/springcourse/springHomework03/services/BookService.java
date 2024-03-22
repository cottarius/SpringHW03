package ru.cotarius.springcourse.springHomework03.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.cotarius.springcourse.springHomework03.model.Book;
import ru.cotarius.springcourse.springHomework03.repository.JpaBookRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    //private final BookRepository bookRepository;
    private final JpaBookRepository bookRepository;

    public Book createBook(String name) {
        Book book = new Book(name);
        //bookRepository.addBook(book);
        bookRepository.save(book);
        return book;
    }

    public Book getBookById(long id) {
        //return bookRepository.getById(id);
        return bookRepository.getReferenceById(id);
    }

    public List<Book> getAllBooks() {
        //return bookRepository.getAllBooks();
        return bookRepository.findAll().stream().toList();
    }

    public void deleteBook(long id){
        Book book = bookRepository.getReferenceById(id);
        bookRepository.delete(book);
    }

//    public boolean deleteBook(long id) {
//        Book book = bookRepository.getById(id);
//        return bookRepository.deleteBook(book);
//    }
}


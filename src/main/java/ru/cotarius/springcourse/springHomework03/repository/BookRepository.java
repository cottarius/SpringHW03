package ru.cotarius.springcourse.springHomework03.repository;

import org.springframework.stereotype.Repository;
import ru.cotarius.springcourse.springHomework03.model.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    List<Book> books = new ArrayList<>();

    {
        books.add(new Book("Война и Мир"));
        books.add(new Book("Преступление и наказание"));
        books.add(new Book("Мастер и Маргарита"));
        books.add(new Book("Евгений Онегин"));
        books.add(new Book("Идиот"));
        books.add(new Book("Поднятая целина"));
    }


    public Book getById(long id){
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }
    public void addBook(Book book){
        books.add(book);
    }
    public List<Book> getAllBooks(){
        return books;
    }
}

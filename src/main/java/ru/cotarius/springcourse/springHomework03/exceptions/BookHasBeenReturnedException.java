package ru.cotarius.springcourse.springHomework03.exceptions;

public class BookHasBeenReturnedException extends RuntimeException{
    public BookHasBeenReturnedException(String s) {
        super(s);
    }
}

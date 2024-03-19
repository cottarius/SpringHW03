package ru.cotarius.springcourse.springHomework03.exceptions;

public class MoreThanAllowedBooksException extends IllegalStateException{
    public MoreThanAllowedBooksException(String message) {
        super(message);
    }
}

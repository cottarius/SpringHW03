package ru.cotarius.springcourse.springHomework03.exceptions;

public class AllreadyHaveBook extends RuntimeException{
    public AllreadyHaveBook(String s) {
        super(s);
    }
}

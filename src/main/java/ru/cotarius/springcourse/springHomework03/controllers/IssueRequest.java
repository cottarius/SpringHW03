package ru.cotarius.springcourse.springHomework03.controllers;

import lombok.Data;

@Data
public class IssueRequest {
    private final long readerId;
    private final long bookId;
    //private final String bookName;
}

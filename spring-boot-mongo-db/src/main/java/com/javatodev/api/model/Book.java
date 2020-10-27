package com.javatodev.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Book {

    @Id
    private String id;
    private String name;
    private String isbn;
    @DBRef
    private Author author;

}

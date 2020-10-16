package com.javatodev.api.rest.request;

import lombok.Data;

@Data
public class BooksResponse {
    private String bookIsbn;
    private String authorName;
    private Double netPrice;
}

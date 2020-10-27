package com.javatodev.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Document
public class Lend {

    @Id
    private String id;
    private LendStatus status;
    private Instant startOn;
    private Instant dueOn;
    @DBRef
    private Book book;
    @DBRef
    private Member member;

}

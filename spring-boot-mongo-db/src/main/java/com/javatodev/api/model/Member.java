package com.javatodev.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Member {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private MemberStatus status;

}

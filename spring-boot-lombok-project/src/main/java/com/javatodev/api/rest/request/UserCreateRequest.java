package com.javatodev.api.rest.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserCreateRequest {
    private String username;
    private String password;
    private String bCode;
}

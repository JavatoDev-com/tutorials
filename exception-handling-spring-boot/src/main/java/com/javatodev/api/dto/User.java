package com.javatodev.api.dto;

import com.javatodev.api.common.UserStatus;

import lombok.Data;

@Data
public class User {
    private String username;
    private UserStatus userStatus;
    private String airlineId;
}

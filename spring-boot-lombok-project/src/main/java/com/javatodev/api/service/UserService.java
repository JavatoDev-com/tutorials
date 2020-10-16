package com.javatodev.api.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String readUser () {
        return "John Doe";
    }
}

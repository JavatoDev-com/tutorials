package com.javatodev.api.controller;

import com.javatodev.api.Util.LoggerTestUtil;
import com.javatodev.api.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class BaseAPIController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Void> readUserFromDB (@PathVariable Long id) {

        userService.readUser();

        LoggerTestUtil loggerTestUtil = new LoggerTestUtil();
        loggerTestUtil.doTheRandomLog();

        return ResponseEntity.ok().build();
    }

}

package com.javatodev.api.controller;

import com.javatodev.api.dto.User;
import com.javatodev.api.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity readUser (@PathVariable String username) {
        return ResponseEntity.ok(userService.readUserByUsername(username));
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user){
        userService.createUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/airline/{airlineId}")
    public ResponseEntity createUser(@PathVariable String airlineId){
        return ResponseEntity.ok(userService.readAirline(airlineId));
    }


}

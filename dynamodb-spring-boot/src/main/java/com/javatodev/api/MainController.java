package com.javatodev.api;

import com.javatodev.api.model.User;
import com.javatodev.api.repository.UserRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/rest")
@RequiredArgsConstructor
public class MainController {

    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity create() {
        User user = new User();
        user.setPassword("9229292929");
        user.setUsername("s8979432749382");
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
}

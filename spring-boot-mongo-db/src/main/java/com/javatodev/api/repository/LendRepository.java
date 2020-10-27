package com.javatodev.api.repository;

import com.javatodev.api.model.Book;
import com.javatodev.api.model.Lend;
import com.javatodev.api.model.LendStatus;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LendRepository extends MongoRepository<Lend, String> {
    Optional<Lend> findByBookAndStatus(Book book, LendStatus status);
}

package com.javatodev.api.repository;

import com.javatodev.api.model.Author;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}

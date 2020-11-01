package com.javatodev.api.repository;

import com.javatodev.api.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}

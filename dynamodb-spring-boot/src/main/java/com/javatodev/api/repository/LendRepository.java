package com.javatodev.api.repository;

import com.javatodev.api.model.Book;
import com.javatodev.api.model.Lend;
import com.javatodev.api.model.LendStatus;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
@EnableScan
public interface LendRepository extends CrudRepository<Lend, String> {
    Optional<Lend> findByBookIdAndStatus(String bookId, LendStatus status);
}

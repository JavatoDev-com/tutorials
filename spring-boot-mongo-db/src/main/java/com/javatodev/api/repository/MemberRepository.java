package com.javatodev.api.repository;

import com.javatodev.api.model.Member;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, String> {
}

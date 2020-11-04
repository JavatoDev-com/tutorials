package com.javatodev.api.repository;

import com.javatodev.api.model.Member;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface MemberRepository extends CrudRepository<Member, String> {
}

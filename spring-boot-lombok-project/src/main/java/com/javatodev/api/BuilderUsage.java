package com.javatodev.api;

import com.javatodev.api.rest.request.BuilderTestRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BuilderUsage {

    public static void main(String[] args) {
        BuilderTestRequest symond_doe = BuilderTestRequest.builder().name("Symond Doe").build();
        BuilderTestRequest raymond_doe = BuilderTestRequest.builder().name("Raymond Doe").totalSalary(2000.00).build();
        BuilderTestRequest john_doe = BuilderTestRequest.builder().name("John Doe").totalSalary(200000.00).number(5996).build();
        log.info("Build {} ", symond_doe.toString());
        log.info("Built {} ", raymond_doe.toString());
        log.info("Built {} ", john_doe.toString());
    }

}

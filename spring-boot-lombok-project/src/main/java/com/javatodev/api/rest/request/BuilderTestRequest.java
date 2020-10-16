package com.javatodev.api.rest.request;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class BuilderTestRequest {
    private String name;
    private Integer number;
    private Double totalSalary;
}

package com.javatodev.feign.rest.response;

import lombok.Data;

@Data
public class Airline {
    private Long id;
    private String name;
    private String country;
    private String logo;
    private String slogan;
    private String head_quaters;
    private String website;
    private String established;
}

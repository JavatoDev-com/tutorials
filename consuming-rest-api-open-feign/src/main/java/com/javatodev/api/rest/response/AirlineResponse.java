package com.javatodev.api.rest.response;

import lombok.Data;

@Data
public class AirlineResponse {
    private Long id;
    private String name;
    private String country;
    private String logo;
    private String slogan;
    private String head_quaters;
    private String website;
    private String established;
}

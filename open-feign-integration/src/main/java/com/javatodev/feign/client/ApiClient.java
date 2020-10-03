package com.javatodev.feign.client;

import com.javatodev.feign.config.CustomFeignClientConfiguration;
import com.javatodev.feign.rest.response.Airline;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "${app.feign.config.name}", url = "${app.feign.config.url}", configuration = CustomFeignClientConfiguration.class)
public interface ApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/airlines")
    List<Airline> readAirLines();

    @RequestMapping(method = RequestMethod.GET, value = "/airlines/{airlineId}")
    Airline readAirLineById(@PathVariable("airlineId") String airlineId);


}

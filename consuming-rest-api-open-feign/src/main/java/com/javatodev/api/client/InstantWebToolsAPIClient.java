package com.javatodev.api.client;

import com.javatodev.api.config.CustomFeignClientConfiguration;
import com.javatodev.api.rest.request.AirlineCreateRequest;
import com.javatodev.api.rest.request.PassengerUpdateRequest;
import com.javatodev.api.rest.response.AirlineResponse;
import com.javatodev.api.rest.response.PaginatedPassengerResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "${app.feign.config.name}", url = "${app.feign.config.url}", configuration = CustomFeignClientConfiguration.class)
public interface InstantWebToolsAPIClient {

    @RequestMapping(method = RequestMethod.GET, value = "/airlines")
    List<AirlineResponse> readAirLines();

    @RequestMapping(method = RequestMethod.GET, value = "/airlines/{airlineId}")
    AirlineResponse readAirLineById(@PathVariable String airlineId);

    @RequestMapping(method = RequestMethod.GET, value = "/passenger")
    PaginatedPassengerResponse readPassengers(@RequestParam("size") Long size, @RequestParam("page") Long page);

    @RequestMapping(method = RequestMethod.POST, value = "/airlines")
    AirlineResponse createAirline(@RequestBody AirlineCreateRequest airlineCreateRequest);

    @RequestMapping(method = RequestMethod.DELETE, value = "/passenger/{passengerId}")
    String deletePassenger(@PathVariable String passengerId);

    @RequestMapping(method = RequestMethod.PATCH, value = "/passenger/{passengerId}")
    String updatePassenger(@PathVariable String passengerId, @RequestBody PassengerUpdateRequest request);

}

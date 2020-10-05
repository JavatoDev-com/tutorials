package com.javatodev.api.controller;

import com.javatodev.api.client.InstantWebToolsAPIClient;
import com.javatodev.api.rest.request.AirlineCreateRequest;
import com.javatodev.api.rest.request.PassengerUpdateRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class ApiController {

    private final InstantWebToolsAPIClient apiClient;

    @GetMapping(value = "/airline")
    public ResponseEntity readAirlineData (@RequestParam(required = false) String airlineId) {
        if (airlineId == null) {
            return ResponseEntity.ok(apiClient.readAirLines());
        }
        return ResponseEntity.ok(apiClient.readAirLineById(airlineId));
    }

    @GetMapping(value = "/passengers")
    public ResponseEntity readPassengers () {
        return ResponseEntity.ok(apiClient.readPassengers(20L, 0L));
    }

    @PostMapping(value = "/airline")
    public ResponseEntity createAirline (@RequestBody AirlineCreateRequest request) {
        return ResponseEntity.ok(apiClient.createAirline(request));
    }

    @DeleteMapping(value = "/passenger/{id}")
    public ResponseEntity deletePassenger (@PathVariable String id) {
        return ResponseEntity.ok(apiClient.deletePassenger(id));
    }

    @PatchMapping(value = "/passenger/{id}")
    public ResponseEntity updatePassenger (@PathVariable String id, @RequestBody PassengerUpdateRequest request) {
        return ResponseEntity.ok(apiClient.updatePassenger(id, request));
    }

}

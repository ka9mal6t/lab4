package com.example.demo.controller;


import com.example.demo.dto.FlightDTO;
import com.example.demo.models.Flight;
import com.example.demo.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
@AllArgsConstructor
public class FlightController {

    FlightService flightService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    public List<Flight> getFlights() {
        return flightService.getAllFlights();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/{number}")
    public List<Flight> getFlightsByNumber(@PathVariable int number) {
        return flightService.findByNumber(number);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Flight createFlight(@RequestBody FlightDTO newFlight) {
        return flightService.createFlight(newFlight);
    }

}

package com.example.demo.controllers;


import com.example.demo.models.Flight;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/flights")
public class FlightController {

    private static final List<Flight> flights = new ArrayList<>(List.of(
        new Flight(1L, "Kyiv", "Lviv",
                LocalDateTime.of(2024, 11, 15, 10, 0),
                LocalDateTime.of(2024, 11, 15, 12, 0),
                new BigDecimal("150.00"), "FL123", LocalDateTime.now()),

        new Flight(2L, "Kyiv", "Odessa",
                LocalDateTime.of(2024, 11, 16, 14, 30),
                LocalDateTime.of(2024, 11, 16, 16, 30),
                new BigDecimal("200.00"), "FL456", LocalDateTime.now()),

        new Flight(3L, "Kyiv", "Kharkiv",
                LocalDateTime.of(2024, 11, 17, 18, 45),
                LocalDateTime.of(2024, 11, 17, 20, 45),
                new BigDecimal("180.00"), "FL789", LocalDateTime.now())));

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        return ResponseEntity.ok(flights);
    }

    private Optional<Flight> findFlightById(Long id){
        return flights.stream().filter(f -> f.getId().equals(id)).findFirst();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlight(@PathVariable Long id){


        return findFlightById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody FlightDTO newFlight){

        Flight flight = new Flight(flights.size() + 1L, newFlight, LocalDateTime.now());

        flights.add(flight);

        return ResponseEntity.status(HttpStatus.CREATED).body(flight);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {

        boolean removed = flights.removeIf(f -> f.getId().equals(id));

        if (removed) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}

package com.example.demo.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class FlightDTO {

    private String departure;
    private String arrival;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private BigDecimal price;
    private String flightNumber;
}

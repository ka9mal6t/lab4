package com.example.demo.models;

import com.example.demo.controllers.FlightDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Flight {

    private Long id;
    private String departure;
    private String arrival;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private BigDecimal price;
    private String flightNumber;
    private LocalDateTime creationDate;

    public Flight(Long id, FlightDTO newFlight, LocalDateTime creationDate) {
        this.id = id;
        this.departure = newFlight.getDeparture();
        this.arrival = newFlight.getArrival();
        this.departureDateTime = newFlight.getDepartureDateTime();
        this.arrivalDateTime = newFlight.getArrivalDateTime();
        this.price = newFlight.getPrice();
        this.flightNumber = newFlight.getFlightNumber();
        this.creationDate = creationDate;
    }

}


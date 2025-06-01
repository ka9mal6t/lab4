package com.example.demo.controller;

import com.example.demo.models.City;
import com.example.demo.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@AllArgsConstructor
public class CityController {
    CityService cityService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }
}

package com.example.earthquaketracker.controller;

import com.example.earthquaketracker.model.Earthquake;
import com.example.earthquaketracker.service.EarthquakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/earthquakes")
public class EarthquakeController {

    private final EarthquakeService earthquakeService;

    @Autowired
    public EarthquakeController(EarthquakeService earthquakeService) {
        this.earthquakeService = earthquakeService;
    }

    @GetMapping
    public List<Earthquake> getRecentEarthquakes() {
        return earthquakeService.getRecentEarthquakes();
    }
}
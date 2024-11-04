package com.example.earthquaketracker.controller;

import com.example.earthquaketracker.model.SeismographData;
import com.example.earthquaketracker.service.SeismographService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seismograph")
public class SeismographController {

    private final SeismographService seismographService;

    @Autowired
    public SeismographController(SeismographService seismographService) {
        this.seismographService = seismographService;
    }

    @GetMapping
    public SeismographData getSeismographData() {
        return seismographService.getSeismographData();
    }
}
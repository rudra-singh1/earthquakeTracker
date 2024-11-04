package com.example.earthquaketracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EarthquakeTrackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EarthquakeTrackerApplication.class, args);
    }
}
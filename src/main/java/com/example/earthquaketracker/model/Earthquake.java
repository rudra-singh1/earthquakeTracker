package com.example.earthquaketracker.model;

import lombok.Data;

import java.time.Instant;

@Data
public class Earthquake {
    private String id;
    private double magnitude;
    private String place;
    private Instant time;
    private double latitude;
    private double longitude;
    private double depth;
}
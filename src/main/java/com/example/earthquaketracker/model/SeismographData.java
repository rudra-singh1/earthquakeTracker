package com.example.earthquaketracker.model;

import lombok.Data;

import java.util.List;

@Data
public class SeismographData {
    private List<Double> amplitudes;
    private List<Long> timestamps;
}
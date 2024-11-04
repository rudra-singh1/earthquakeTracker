package com.example.earthquaketracker.service;

import com.example.earthquaketracker.model.Earthquake;
import com.example.earthquaketracker.util.USGSApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EarthquakeService {

    private final USGSApiClient usgsApiClient;

    @Autowired
    public EarthquakeService(USGSApiClient usgsApiClient) {
        this.usgsApiClient = usgsApiClient;
    }

    public List<Earthquake> getRecentEarthquakes() {
        return usgsApiClient.fetchRecentEarthquakes();
    }
}
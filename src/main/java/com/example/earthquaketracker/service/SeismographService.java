package com.example.earthquaketracker.service;

import com.example.earthquaketracker.model.SeismographData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SeismographService {

    public SeismographData getSeismographData() {
        SeismographData data = new SeismographData();
        data.setAmplitudes(generateRandomAmplitudes(100));
        data.setTimestamps(generateTimestamps(100));
        return data;
    }

    private List<Double> generateRandomAmplitudes(int count) {
        List<Double> amplitudes = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            amplitudes.add(random.nextDouble() * 10 - 5);
        }
        return amplitudes;
    }

    private List<Long> generateTimestamps(int count) {
        List<Long> timestamps = new ArrayList<>();
        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            timestamps.add(currentTime - (count - i) * 1000);
        }
        return timestamps;
    }
}
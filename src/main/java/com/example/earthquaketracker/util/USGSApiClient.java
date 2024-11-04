package com.example.earthquaketracker.util;

import com.example.earthquaketracker.model.Earthquake;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
public class USGSApiClient {

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    public USGSApiClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/").build();
        this.objectMapper = new ObjectMapper();
    }

    public List<Earthquake> fetchRecentEarthquakes() {
        String response = webClient.get()
                .uri("all_hour.geojson")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        List<Earthquake> earthquakes = new ArrayList<>();

        try {
            JsonNode root = objectMapper.readTree(response);
            JsonNode features = root.get("features");

            for (JsonNode feature : features) {
                JsonNode properties = feature.get("properties");
                JsonNode geometry = feature.get("geometry");

                Earthquake earthquake = new Earthquake();
                earthquake.setId(feature.get("id").asText());
                earthquake.setMagnitude(properties.get("mag").asDouble());
                earthquake.setPlace(properties.get("place").asText());
                earthquake.setTime(Instant.ofEpochMilli(properties.get("time").asLong()));
                earthquake.setLatitude(geometry.get("coordinates").get(1).asDouble());
                earthquake.setLongitude(geometry.get("coordinates").get(0).asDouble());
                earthquake.setDepth(geometry.get("coordinates").get(2).asDouble());

                earthquakes.add(earthquake);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return earthquakes;
    }
}
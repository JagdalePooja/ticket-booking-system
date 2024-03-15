package com.example.ticketbookingsystem.repository;

import com.example.ticketbookingsystem.model.Station;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Repository
public class StationRepositoryImpl implements StationRepository {

    private final List<Station> stations;
    public StationRepositoryImpl(@Value("classpath:data/stations.json") Resource resource) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Station>> typeReference = new TypeReference<List<Station>>() {};
        stations = mapper.readValue(resource.getInputStream(), typeReference);
    }

    @Override
    public Station getStation(String code) {
        return stations.stream()
                .filter(station -> station.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Station not found"));
    }

    @Override
    public int getPrice(String startStationCode, String endStationCode) {
        Station startStation = getStation(startStationCode);
        Station endStation = getStation(endStationCode);
        int startIndex = stations.indexOf(startStation);
        int endIndex = stations.indexOf(endStation);
        if (startIndex == -1 || endIndex == -1) {
            throw new IllegalArgumentException("Start or end station not found");
        }
        int totalPrice = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            totalPrice += stations.get(i).getPrice();
        }
        return totalPrice;
    }

    @PostConstruct
    public void init() {
        System.out.println("Initialized with " + stations.size() + " stations.");
    }
}

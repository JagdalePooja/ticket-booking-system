package com.example.ticketbookingsystem.repository;

import com.example.ticketbookingsystem.model.Station;

public interface StationRepository {
    Station getStation(String code);
    int getPrice(String startStationCode, String endStationCode);
}

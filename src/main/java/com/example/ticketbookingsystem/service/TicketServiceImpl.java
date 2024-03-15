package com.example.ticketbookingsystem.service;

import com.example.ticketbookingsystem.model.Station;
import com.example.ticketbookingsystem.model.Ticket;
import com.example.ticketbookingsystem.repository.StationRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService {
    private Map<String, Ticket> tickets = new HashMap<>();

    private StationRepository stationRepository;

    public TicketServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public Ticket bookTicket(String startStationCode, String endStationCode) {

        String ticketId = UUID.randomUUID().toString();
        Station startStation = stationRepository.getStation(startStationCode);
        if (startStation == null) {
            throw new IllegalArgumentException("Invalid start station code: " + startStationCode);
        }
        Station endStation = stationRepository.getStation(endStationCode);
        if (endStation == null) {
            throw new IllegalArgumentException("Invalid end station code: " + endStationCode);
        }

        Ticket ticket = new Ticket();
        ticket.setId(ticketId);
        ticket.setStartStation(startStation.getName());
        ticket.setEndStation(endStation.getName());
        ticket.setUsedForEntry(false);
        ticket.setUsedForExit(false);
        ticket.setExpirationTime(System.currentTimeMillis() + 18 * 60 * 60 * 1000);
        tickets.put(ticketId, ticket);

        return ticket;
    }

    @Override
    public boolean validateTicket(String ticketId, boolean forEntry) {
        Ticket ticket = tickets.get(ticketId);
        if (ticket == null || System.currentTimeMillis() > ticket.getExpirationTime()) {
            return false;
        }
        if (forEntry && ticket.isUsedForEntry() || !forEntry && !ticket.isUsedForEntry()) {
            return false;
        }
        if (forEntry) {
            ticket.setUsedForEntry(true);
        } else {
            ticket.setUsedForExit(true);
        }
        return true;
    }
}

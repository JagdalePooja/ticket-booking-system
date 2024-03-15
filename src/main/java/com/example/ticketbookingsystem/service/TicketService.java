package com.example.ticketbookingsystem.service;


import com.example.ticketbookingsystem.model.Ticket;

public interface TicketService {
    Ticket bookTicket(String startStationCode, String endStationCode);
    boolean validateTicket(String ticketId, boolean forEntry);
}

package com.example.ticketbookingsystem.controller;

import com.example.ticketbookingsystem.model.Ticket;
import com.example.ticketbookingsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/book")
    public String showBookingPage() {
        return "book";
    }

    @PostMapping("/book")
    public String bookTicket(@RequestParam String fromStation, @RequestParam String toStation, Model model) {
        Ticket ticket = ticketService.bookTicket(fromStation, toStation);
        model.addAttribute("ticket", ticket);
        return "ticket";
    }
}

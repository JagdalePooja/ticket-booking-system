package com.example.ticketbookingsystem;

import com.example.ticketbookingsystem.config.RepositoryConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(RepositoryConfig.class)
@ComponentScan("com.example.ticketbookingsystem")
public class TicketBookingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketBookingSystemApplication.class, args);
    }

}

package com.example.ticketbookingsystem.config;

import com.example.ticketbookingsystem.repository.StationRepository;
import com.example.ticketbookingsystem.repository.StationRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class RepositoryConfig {
    @Bean
    public StationRepository stationRepository() throws Exception {
        return new StationRepositoryImpl(new ClassPathResource("data/stations.json"));
    }
}

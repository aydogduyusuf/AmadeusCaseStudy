package com.Amadeus.flightSearch.service.impl;

import com.Amadeus.flightSearch.model.Flight;
import com.Amadeus.flightSearch.repository.FlightRepository;
import com.Amadeus.flightSearch.service.FlightDataSchedulerService;
import com.Amadeus.flightSearch.service.MockFlightDataService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FlightDataSchedulerServiceImpl implements FlightDataSchedulerService {
    private final FlightRepository flightRepository;
    private final MockFlightDataService mockFlightDataService;
    @Override
    @Scheduled(cron = "0 0 0 * * ?") // Every day at midnight
    @Transactional
    public void fetchAndSaveFlightData() {
        List<Flight> mockFlights = mockFlightDataService.generateMockFlights(100); // Generate 10 mock flights
        flightRepository.saveAll(mockFlights);
    }
}

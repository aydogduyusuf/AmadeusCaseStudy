package com.Amadeus.flightSearch.service.impl;

import com.Amadeus.flightSearch.model.Flight;
import com.Amadeus.flightSearch.model.Airport;
import com.Amadeus.flightSearch.repository.AirportRepository;
import com.Amadeus.flightSearch.service.MockFlightDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class MockFlightDataServiceImpl implements MockFlightDataService {
    private final AirportRepository airportRepository;
    private final Random random = new Random();

    @Override
    public List<Flight> generateMockFlights(int numberOfFlights) {
        List<Airport> airports = (List<Airport>) airportRepository.findAll();
        List<Flight> flights = new ArrayList<>();

        for (int i = 0; i < numberOfFlights; i++) {
            Flight flight = new Flight();
            flight.setFromAirport(getRandomAirport(airports));
            flight.setToAirport(getRandomAirport(airports));
            // Generate a random date within the next 30 days
            LocalDate randomDate = LocalDate.now().plusDays(random.nextInt(30));
            // Generate a random time
            LocalTime randomTime = LocalTime.of(random.nextInt(24), random.nextInt(60));

            // Combine the random date and time
            LocalDateTime randomDateTime = LocalDateTime.of(randomDate, randomTime);

            flight.setDepartureTime(randomDateTime);
            flight.setPrice(100.0 + random.nextDouble() * 900.0); // Random price between 100 and 1000

            flights.add(flight);
        }
        return flights;
    }
    private Airport getRandomAirport(List<Airport> airports) {
        return airports.get(random.nextInt(airports.size()));
    }
}

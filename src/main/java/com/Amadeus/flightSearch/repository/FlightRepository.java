package com.Amadeus.flightSearch.repository;

import com.Amadeus.flightSearch.model.Airport;
import com.Amadeus.flightSearch.model.Flight;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Long> {
    List<Flight> findFlightsByFromAirportAndToAirportAndDepartureTimeBetween(Airport fromAirport, Airport toAirport, LocalDateTime departureTime, LocalDateTime departureTime2);
}

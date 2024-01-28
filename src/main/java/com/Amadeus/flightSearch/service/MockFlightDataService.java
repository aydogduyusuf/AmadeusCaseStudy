package com.Amadeus.flightSearch.service;

import com.Amadeus.flightSearch.model.Flight;

import java.util.List;

public interface MockFlightDataService {
    List<Flight> generateMockFlights(int numberOfFlights);
}

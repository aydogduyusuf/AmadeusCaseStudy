package com.Amadeus.flightSearch.service;

import com.Amadeus.flightSearch.dto.FindFlightResponseDTO;

import java.util.List;

public interface FlightService {
    List<List<FindFlightResponseDTO>> findFlights(
             String fromAirportCode, String toAirportCode, String departureTimeStr, String returnTimeStr);
}

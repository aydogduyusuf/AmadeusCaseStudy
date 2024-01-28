package com.Amadeus.flightSearch.controller;

import com.Amadeus.flightSearch.dto.FindFlightResponseDTO;
import com.Amadeus.flightSearch.service.FlightService;
import com.Amadeus.flightSearch.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/flight-search")
public class FlightController {
    private final FlightService flightService;
    @GetMapping("/flights")
    public ApiResponse<List<List<FindFlightResponseDTO>>> flights(@RequestParam("fromAirportCode") String fromAirportCode,
                                                            @RequestParam("toAirportCode") String toAirportCode,
                                                            @RequestParam("departureDate") String departureDate,
                                                            @RequestParam(value = "returnDate", required = false) String returnDate) {
        return new ApiResponse<>(flightService.findFlights(fromAirportCode, toAirportCode, departureDate, returnDate));
    }
}

package com.Amadeus.flightSearch.service.impl;

import com.Amadeus.flightSearch.dto.FindFlightResponseDTO;
import com.Amadeus.flightSearch.exception.AirportNotFoundException;
import com.Amadeus.flightSearch.model.Airport;
import com.Amadeus.flightSearch.model.Flight;
import com.Amadeus.flightSearch.repository.AirportRepository;
import com.Amadeus.flightSearch.repository.FlightRepository;
import com.Amadeus.flightSearch.service.FlightService;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;

    @Override
    public List<List<FindFlightResponseDTO>> findFlights(String fromAirportCode, String toAirportCode, String departureTimeStr, String returnTimeStr) {
        Airport fromAirport = getAirport(fromAirportCode);
        Airport toAirport = getAirport(toAirportCode);
        LocalDate departureDate = LocalDate.parse(departureTimeStr, DateTimeFormatter.ISO_LOCAL_DATE);
        List<List<FindFlightResponseDTO>> response = new ArrayList<>();
        List<Flight> outboundFlights = findFlightsBetween(fromAirport, toAirport, departureDate);
        List<FindFlightResponseDTO> flightDTOS = outboundFlights.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        response.add(flightDTOS);
        if (!StringUtils.isEmpty(returnTimeStr)) {
            LocalDate returnDate = LocalDate.parse(returnTimeStr, DateTimeFormatter.ISO_LOCAL_DATE);
            List<Flight> returnFlights = findFlightsBetween(toAirport, fromAirport, returnDate);
            List<FindFlightResponseDTO> returnFlightDTOS = returnFlights.stream().map(this::convertToDTO).toList();
            response.add(returnFlightDTOS);
        }

        return response;
    }

    private List<Flight> findFlightsBetween(Airport fromAirport, Airport toAirport, LocalDate date) {
        return flightRepository.findFlightsByFromAirportAndToAirportAndDepartureTimeBetween(
                fromAirport,
                toAirport,
                getStartOfDay(date),
                getEndOfDay(date)
        );
    }

    private LocalDateTime getStartOfDay(LocalDate date) {
        return date.atStartOfDay();
    }

    private LocalDateTime getEndOfDay(LocalDate date) {
        return date.atTime(LocalTime.MAX);
    }

    private FindFlightResponseDTO convertToDTO(Flight flight) {
        return new FindFlightResponseDTO(flight.getFromAirport().getCode(), flight.getToAirport().getCode(),
                flight.getDepartureTime(), flight.getPrice());
    }
    private Airport getAirport(String airportCode) {
        return airportRepository.findByCode(airportCode)
                .orElseThrow(AirportNotFoundException::new);
    }
}

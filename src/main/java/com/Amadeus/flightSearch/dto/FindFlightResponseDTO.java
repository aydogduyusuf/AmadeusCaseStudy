package com.Amadeus.flightSearch.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class FindFlightResponseDTO {
    @JsonProperty("from_airport")
    private String fromAirport;

    @JsonProperty("to_airport")
    private String toAirport;

    @JsonProperty("departure_time")
    private LocalDateTime departureTime;

    @JsonProperty("price")
    private Double price;
}

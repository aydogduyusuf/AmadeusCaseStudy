package com.Amadeus.flightSearch.repository;

import com.Amadeus.flightSearch.model.Airport;
import jakarta.validation.constraints.Size;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AirportRepository extends CrudRepository<Airport, Long> {
    Optional<Airport> findByCode(@Size(min = 3, max = 3, message = "airport code must be 3 characters long") String code);
}

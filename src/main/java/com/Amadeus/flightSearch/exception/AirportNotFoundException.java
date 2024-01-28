package com.Amadeus.flightSearch.exception;

import com.Amadeus.flightSearch.util.ApiException;
import com.Amadeus.flightSearch.util.ErrorTypes;

public class AirportNotFoundException extends ApiException {
    public AirportNotFoundException() {
        super(ErrorTypes.AIRPORT_NOT_FOUND.getCode(), ErrorTypes.AIRPORT_NOT_FOUND.getMessage());
    }
}

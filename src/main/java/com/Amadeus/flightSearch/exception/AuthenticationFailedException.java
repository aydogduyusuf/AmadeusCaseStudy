package com.Amadeus.flightSearch.exception;

import com.Amadeus.flightSearch.util.ApiException;
import com.Amadeus.flightSearch.util.ErrorTypes;

public class AuthenticationFailedException extends ApiException {
    public AuthenticationFailedException() {
        super(ErrorTypes.AUTHENTICATION_FAILED.getCode(), ErrorTypes.AUTHENTICATION_FAILED.getMessage());
    }
}

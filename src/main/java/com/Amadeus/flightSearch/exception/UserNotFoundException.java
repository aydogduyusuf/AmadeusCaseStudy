package com.Amadeus.flightSearch.exception;

import com.Amadeus.flightSearch.util.ApiException;
import com.Amadeus.flightSearch.util.ErrorTypes;

public class UserNotFoundException extends ApiException {
    public UserNotFoundException() {
        super(ErrorTypes.USER_NOT_FOUND.getCode(), ErrorTypes.USER_NOT_FOUND.getMessage());
    }
}

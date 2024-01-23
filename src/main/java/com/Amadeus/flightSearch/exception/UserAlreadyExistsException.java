package com.Amadeus.flightSearch.exception;

import com.Amadeus.flightSearch.util.ApiException;
import com.Amadeus.flightSearch.util.ErrorTypes;

public class UserAlreadyExistsException extends ApiException {

    public UserAlreadyExistsException() {
        super(ErrorTypes.USER_ALREADY_EXISTS.getCode(), ErrorTypes.USER_ALREADY_EXISTS.getMessage());
    }
}

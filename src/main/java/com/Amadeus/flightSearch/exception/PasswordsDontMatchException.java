package com.Amadeus.flightSearch.exception;

import com.Amadeus.flightSearch.util.ApiException;
import com.Amadeus.flightSearch.util.ErrorTypes;

public class PasswordsDontMatchException extends ApiException {
    public PasswordsDontMatchException() {
        super(ErrorTypes.PASSWORDS_DONT_MATCH.getCode(), ErrorTypes.PASSWORDS_DONT_MATCH.getMessage());
    }
}

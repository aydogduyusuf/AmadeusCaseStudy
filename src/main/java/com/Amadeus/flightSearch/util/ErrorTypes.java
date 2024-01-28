package com.Amadeus.flightSearch.util;


import lombok.Getter;

@Getter
public enum ErrorTypes {
    AIRPORT_NOT_FOUND(200, "Airport can't found"),
    INTERNAL_SERVER_ERROR(500, "Something went wrong"),
    AUTHENTICATION_FAILED(103, "Invalid email or password"),
    PASSWORDS_DONT_MATCH(102, "Please give the same password"),
    USER_NOT_FOUND(101, "No user with the given email"),
    USER_ALREADY_EXISTS(100,"User already exists with the given email");


    private final int code;
    private final String message;

    ErrorTypes(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

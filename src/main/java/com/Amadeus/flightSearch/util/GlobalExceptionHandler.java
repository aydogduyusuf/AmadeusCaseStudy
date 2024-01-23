package com.Amadeus.flightSearch.util;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.OK)
    public final ApiResponse<ApiException> handleApiExceptions(ApiException apiException) {
        return new ApiResponse<>(apiException);
    }

    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ApiResponse<ApiException> handleInternalServerExceptions(Exception exception) {
        return new ApiResponse<>(new ApiException(ErrorTypes.INTERNAL_SERVER_ERROR.getCode(), ErrorTypes.INTERNAL_SERVER_ERROR.getMessage()));
    }
}

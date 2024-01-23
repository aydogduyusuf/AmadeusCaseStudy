package com.Amadeus.flightSearch.util;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiException extends RuntimeException{
    private int errorCode;
    private String errorKey;

    public ApiResult getApiResult() {
        return new ApiResult(this.errorCode, this.errorKey);
    }
}

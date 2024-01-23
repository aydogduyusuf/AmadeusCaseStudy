package com.Amadeus.flightSearch.util;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T>{
    private T data;
    private ApiResult result;

    public ApiResponse() {
        this((T) null);
    }

    public ApiResponse(T data) {
        this.data = data;
        this.result = new ApiResult(0, "success");
    }

    public ApiResponse(ApiException exception) {
        this.data = null;
        this.result = exception.getApiResult();
    }
}

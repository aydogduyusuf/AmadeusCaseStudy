package com.Amadeus.flightSearch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginResponseDTO {
    @JsonProperty("token")
    private String jwtToken;
}

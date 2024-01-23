package com.Amadeus.flightSearch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRegisterResponseDTO {
    @JsonProperty("user_id")
    private Long userId;
}

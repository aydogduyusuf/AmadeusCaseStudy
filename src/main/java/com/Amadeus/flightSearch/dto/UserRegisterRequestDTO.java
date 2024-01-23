package com.Amadeus.flightSearch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequestDTO {
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    @NotNull(message = "Email is required")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Password is required")
    @NotNull(message = "Password is required")
    @Size(min = 8, message = "Password should be at least 8 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, and one numeric character")
    @JsonProperty("password")
    private String password;


    @NotBlank(message = "Password is required")
    @NotNull(message = "Password is required")
    @Size(min = 8, message = "Password should be at least 8 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, and one numeric character")
    @JsonProperty("password_copy")
    private String passwordCopy;

    public boolean doesPasswordsMatch() {
        return password.equals(passwordCopy);
    }
}

package com.Amadeus.flightSearch.controller;

import com.Amadeus.flightSearch.service.UserService;
import com.Amadeus.flightSearch.dto.*;
import com.Amadeus.flightSearch.util.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    @Operation(summary = "User Registration",
            description = "Registers a user with the provided email and password.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "0", description = "successful operation"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "100", description = "user already exists error"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "102", description = "passwords don't match error"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "internal server error")
    })
    public ApiResponse<UserRegisterResponseDTO> registerUser(@Valid @RequestBody UserRegisterRequestDTO userRegisterRequestDTO) {
        return new ApiResponse<>(userService.registerUser(userRegisterRequestDTO));
    }

    @PostMapping("/login")
    @Operation(summary = "User Login",
            description = "Authenticates the user with the provided login credentials.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "0", description = "successful operation"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "101", description = "user not found error"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "103", description = "invalid username or password error"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "internal server error")
    })
    public ApiResponse<UserLoginResponseDTO> loginUser(@Valid @RequestBody UserLoginRequestDTO userLoginRequestDTO) {
        return new ApiResponse<>(userService.loginUser(userLoginRequestDTO));
    }
}

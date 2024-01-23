package com.Amadeus.flightSearch.service;

import com.Amadeus.flightSearch.dto.*;

public interface UserService {
    UserRegisterResponseDTO registerUser(UserRegisterRequestDTO userRegisterRequestDTO);
    UserLoginResponseDTO loginUser(UserLoginRequestDTO userLoginRequestDTO);
}

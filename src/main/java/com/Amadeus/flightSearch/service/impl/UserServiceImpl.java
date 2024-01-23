package com.Amadeus.flightSearch.service.impl;

import com.Amadeus.flightSearch.dto.UserLoginRequestDTO;
import com.Amadeus.flightSearch.dto.UserLoginResponseDTO;
import com.Amadeus.flightSearch.dto.UserRegisterRequestDTO;
import com.Amadeus.flightSearch.dto.UserRegisterResponseDTO;
import com.Amadeus.flightSearch.exception.*;
import com.Amadeus.flightSearch.model.User;
import com.Amadeus.flightSearch.repository.UserRepository;
import com.Amadeus.flightSearch.service.UserService;
import com.Amadeus.flightSearch.util.ApiResponse;
import com.Amadeus.flightSearch.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public UserRegisterResponseDTO registerUser(UserRegisterRequestDTO userRegisterRequestDTO) {
        Optional<User> optionalUser = userRepository.findUserByEmail(userRegisterRequestDTO.getEmail());
        if (optionalUser.isPresent()) {
            throw new UserAlreadyExistsException();
        }
        if (!userRegisterRequestDTO.doesPasswordsMatch()) {
            throw new PasswordsDontMatchException();
        }
        User user = createUser(userRegisterRequestDTO);
        return UserRegisterResponseDTO.builder().userId(user.getId()).build();
    }



    @Override
    public UserLoginResponseDTO loginUser(UserLoginRequestDTO userLoginRequestDTO) {
        Optional<User> optionalUser = userRepository.findUserByEmail(userLoginRequestDTO.getEmail());
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException();
        }
        try{
            String jwtToken = getJwtToken(userLoginRequestDTO);
            UserLoginResponseDTO response = new UserLoginResponseDTO();
            response.setJwtToken(jwtToken);
            return response;
        }
        catch (AuthenticationException e){
            throw new AuthenticationFailedException();
        }
    }

    private String getJwtToken(UserLoginRequestDTO userLoginRequestDTO) {
        Authentication auth = new UsernamePasswordAuthenticationToken(userLoginRequestDTO.getEmail(), userLoginRequestDTO.getPassword());
        Authentication authenticateUser = authenticationManager.authenticate(auth);
        return jwtUtil.generateToken(authenticateUser);
    }

    private User createUser(UserRegisterRequestDTO userRegisterRequestDTO) {
        User user = new User();
        user.setEmail(userRegisterRequestDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterRequestDTO.getPassword()));
        user.setCreateDate(LocalDateTime.now());
        user = userRepository.save(user);
        return user;
    }
}

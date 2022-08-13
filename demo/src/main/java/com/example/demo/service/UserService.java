package com.example.demo.service;

import com.example.demo.dtos.request.LoginRequest;
import com.example.demo.dtos.request.SignupRequest;
import org.springframework.http.ResponseEntity;

public interface UserService{

    ResponseEntity<?> login(LoginRequest loginRequest);

    ResponseEntity<?> signup(SignupRequest signUpRequest);


    Integer getIdFromJwt(String jwt);
}

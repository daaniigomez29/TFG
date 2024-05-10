package com.daniel.tfg.controller;

import com.daniel.tfg.auth.AuthResponse;
import com.daniel.tfg.model.dto.LoginRequest;
import com.daniel.tfg.model.dto.RegisterRequest;
import com.daniel.tfg.model.dto.UserModelDto;
import org.springframework.http.ResponseEntity;

public interface AuthController {

    public ResponseEntity<AuthResponse> login(LoginRequest loginRequest);
    public ResponseEntity<UserModelDto> register(RegisterRequest registerRequest);
}

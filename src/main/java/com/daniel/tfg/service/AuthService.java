package com.daniel.tfg.service;

import com.daniel.tfg.auth.AuthResponse;
import com.daniel.tfg.model.dto.LoginRequest;
import com.daniel.tfg.model.dto.RegisterRequest;
import com.daniel.tfg.model.dto.UserModelDto;

public interface AuthService {
    public AuthResponse login(LoginRequest loginRequest);
    public UserModelDto register(RegisterRequest registerRequest);
}

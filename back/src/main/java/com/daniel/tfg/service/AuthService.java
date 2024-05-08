package com.daniel.tfg.service;

import com.daniel.tfg.auth.AuthResponse;
import com.daniel.tfg.model.dto.LoginRequest;
import com.daniel.tfg.model.dto.RegisterRequest;
import com.daniel.tfg.model.dto.UserDTO;
import com.daniel.tfg.util.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface AuthService {
    public UserDTO login(LoginRequest loginRequest);
    public UserDTO register(RegisterRequest registerRequest);
}

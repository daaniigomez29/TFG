package com.daniel.tfg.controller;

import com.daniel.tfg.model.dto.LoginRequest;
import com.daniel.tfg.model.dto.RegisterRequest;
import com.daniel.tfg.model.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface AuthController {

    public ResponseEntity<UserDTO> login(LoginRequest loginRequest);
    public ResponseEntity<UserDTO> register(RegisterRequest registerRequest);
}

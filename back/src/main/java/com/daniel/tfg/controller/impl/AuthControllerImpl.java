package com.daniel.tfg.controller.impl;

import com.daniel.tfg.controller.AuthController;
import com.daniel.tfg.model.dto.LoginRequest;
import com.daniel.tfg.model.dto.RegisterRequest;
import com.daniel.tfg.model.dto.UserDTO;
import com.daniel.tfg.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginRequest request){
        return  ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }
}

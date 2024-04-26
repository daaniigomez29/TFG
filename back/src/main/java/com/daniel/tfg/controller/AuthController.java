package com.daniel.tfg.controller;

import com.daniel.tfg.entity.auth.AuthResponse;
import com.daniel.tfg.entity.auth.LoginRequest;
import com.daniel.tfg.entity.auth.RegisterRequest;
import com.daniel.tfg.entity.dto.UserDTO;
import com.daniel.tfg.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return  ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @GetMapping("/prueba")
    public String prueba(){
        return "Accedido con token";
    }
}

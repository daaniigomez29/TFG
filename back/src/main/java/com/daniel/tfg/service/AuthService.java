package com.daniel.tfg.service;


import com.daniel.tfg.entity.Role;
import com.daniel.tfg.entity.User;
import com.daniel.tfg.entity.auth.AuthResponse;
import com.daniel.tfg.entity.auth.LoginRequest;
import com.daniel.tfg.entity.auth.RegisterRequest;
import com.daniel.tfg.entity.dto.UserDTO;
import com.daniel.tfg.repository.UserRepository;
import com.daniel.tfg.service.jwt.JwtService;
import com.daniel.tfg.util.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    private final UserMapper userMapper;

    public AuthResponse login(LoginRequest request){
        System.out.println(request.getPassword());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        UserDetails user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.getToken(user);
        System.out.println("token: " + token);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public UserDTO register(RegisterRequest request){
        User user = User.builder()
                .email(request.getEmail())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .role(request.getRole())
                .build();

        userRepository.save(user);

        return userMapper.toUserDTO(user);
    }
}

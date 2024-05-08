package com.daniel.tfg.service.impl;


import com.daniel.tfg.auth.JwtService;
import com.daniel.tfg.model.dto.LoginRequest;
import com.daniel.tfg.model.dto.RegisterRequest;
import com.daniel.tfg.model.User;
import com.daniel.tfg.model.dto.UserDTO;
import com.daniel.tfg.repository.UserRepository;
import com.daniel.tfg.service.AuthService;
import com.daniel.tfg.util.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    private final UserMapper userMapper;

    public UserDTO login(LoginRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        UserDetails user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        User user2 = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.getToken(user);
        UserDTO userDTO = new UserDTO(user2.getId(), user2.getEmail(), user2.getUsername(), user2.getName(), user2.isAdmin(), token);
        return userDTO;
    }

    public UserDTO register(RegisterRequest request){
        User user = User.builder()
                .email(request.getEmail())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .admin(request.isAdmin())
                .build();

        userRepository.save(user);

        return userMapper.toUserDTO(user);
    }
}

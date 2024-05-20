package com.daniel.tfg.service.impl;


import com.daniel.tfg.auth.AuthResponse;
import com.daniel.tfg.auth.JwtService;
import com.daniel.tfg.exception.EmailInvalidException;
import com.daniel.tfg.model.dto.LoginRequest;
import com.daniel.tfg.model.dto.RegisterRequest;
import com.daniel.tfg.model.UserModel;
import com.daniel.tfg.model.dto.UserModelDto;
import com.daniel.tfg.model.dto.UserModelDtoFriends;
import com.daniel.tfg.repository.UserRepository;
import com.daniel.tfg.service.AuthService;
import com.daniel.tfg.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    private final Mapper modelMapper;

    public AuthResponse login(LoginRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        UserDetails user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        UserModel user2 = userRepository.findByEmail(request.getEmail()).orElseThrow();
        UserModelDto userModelDto = modelMapper.toUserDTO(user2);
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("nameuser", user2.getNameuser());
        extraClaims.put("name", user2.getName());
        extraClaims.put("image", user2.getImage());
        extraClaims.put("admin", user2.isAdmin());
        String token = jwtService.getTokenFromService(extraClaims, user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public UserModelDto register(RegisterRequest request){
        boolean userExist;

        userExist = userRepository.findByEmail(request.getEmail()).isPresent();

        if(!userExist) {
            UserModel user = UserModel.builder()
                    .email(request.getEmail())
                    .nameuser(request.getNameuser())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .name(request.getName())
                    .image(request.getImage())
                    .admin(request.isAdmin())
                    .build();

            userRepository.save(user);
            return modelMapper.toUserDTO(user);
        } else{
            throw new EmailInvalidException();
        }
    }
}

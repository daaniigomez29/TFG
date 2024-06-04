package com.daniel.tfg.config;

import com.daniel.tfg.auth.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Clase para configurar la seguridad de la aplicacion
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    /**
     * Declara que peticiones se pueden hacer autenticados y sin tener que estarlo
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest ->
                        authRequest
                                .requestMatchers("/api/v1/auth/**").permitAll()
                                .requestMatchers("/api/v1/users/existsEmail/**").permitAll()
                                .requestMatchers("/api/v1/users/existsNameuser/**").permitAll()
                                .requestMatchers("/api/v1/**").authenticated()
                                .requestMatchers("/chat-socket/**").permitAll()
                                .requestMatchers("/app/**").permitAll()
                                .requestMatchers("/chat/**").permitAll()
                                .requestMatchers("topic/**").permitAll()
                                )
                .sessionManagement(sessionManager ->
                        sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}

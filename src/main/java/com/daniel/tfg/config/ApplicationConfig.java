package com.daniel.tfg.config;

import com.daniel.tfg.model.BookModel;
import com.daniel.tfg.model.FavoriteBooksModel;
import com.daniel.tfg.model.RequestFriendModel;
import com.daniel.tfg.model.UserModel;
import com.daniel.tfg.model.dto.*;
import com.daniel.tfg.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepository userRepository;

    /**
     * Realiza configuracion inicial de authenticationManager
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    /**
     * Inicializa ModelMapper y declara distintos mappers
     */
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        // Configurar el ModelMapper
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        // Mapping FavoriteBooksModel a FavoriteBooksModelDto
        modelMapper.createTypeMap(FavoriteBooksModel.class, FavoriteBooksModelDto.class)
                .addMappings(mapper -> {
                    mapper.map(FavoriteBooksModel::getUserModel, FavoriteBooksModelDto::setUserModelDto);
                    mapper.map(FavoriteBooksModel::getBookModel, FavoriteBooksModelDto::setBookModelDto);
                });

        // Mapping UserModel a UserModelDto
        modelMapper.createTypeMap(UserModel.class, UserModelDto.class);

        // Mapping BookModel a BookModelDto
        modelMapper.createTypeMap(BookModel.class, BookModelDto.class);

        // Mapping RequestFriendModel a RequestFriendModelDto
        modelMapper.createTypeMap(RequestFriendModel.class, RequestFriendModelDto.class)
                .addMappings(mapper -> {
                    mapper.map(RequestFriendModel::getUserRequest, RequestFriendModelDto::setUserModelDtoRequest);
                    mapper.map(RequestFriendModel::getUserReceive, RequestFriendModelDto::setUserModelDtoReceive);
                });

        modelMapper.createTypeMap(RequestFriendModel.class, RequestFriendModelDtoWUserReceive.class)
                .addMappings(mapper -> {
                    mapper.map(RequestFriendModel::getUserRequest, RequestFriendModelDtoWUserReceive::setUserModelDtoRequest);
                });

        modelMapper.createTypeMap(FavoriteBooksModel.class, FavoriteBooksModelDtoWUser.class)
                .addMappings(mapper -> {
                    mapper.map(FavoriteBooksModel::getBookModel, FavoriteBooksModelDtoWUser::setBookModelDto);
                });
        return modelMapper;
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    /**
     * Inicializa BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * Obtiene detalles a partir de un correo
     */
    @Bean
    public UserDetailsService userDetailService(){
        return email -> userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found"));
    }
}

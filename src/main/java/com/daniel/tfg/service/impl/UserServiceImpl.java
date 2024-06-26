package com.daniel.tfg.service.impl;

import com.daniel.tfg.auth.AuthResponse;
import com.daniel.tfg.auth.JwtService;
import com.daniel.tfg.exception.GlobalException;
import com.daniel.tfg.model.UserModel;
import com.daniel.tfg.model.dto.UserModelDto;
import com.daniel.tfg.model.dto.UserModelDtoFriends;
import com.daniel.tfg.repository.UserRepository;
import com.daniel.tfg.service.UserService;
import com.daniel.tfg.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired //Inyecta dependencia de la clase
    private UserRepository userRepository; //Repositorio de la bbdd de usuarios
    @Autowired
    private Mapper modelMapper;

    @Autowired
    private JwtService jwtService;

    /**
     * Obtiene todos los usuarios de la bbdd
     * @return Lista de todos los usuarios mapeados a UserModelDto
     */
    @Override
    public List<UserModelDto> getAllUsers() {
        return userRepository.findAll().stream().map(userModel -> modelMapper.toUserDTO(userModel)).collect(Collectors.toList());
    }

    /**
     * Obtiene todos los amigos del usuario
     * @param id ID del usuario
     * @return Lista de todos los amigos mapeados a UserModelDtoFriends
     */
    @Override
    public List<UserModelDtoFriends> getAllFriends(Integer id) {
        UserModelDto userModelDto = modelMapper.toUserDTO(userRepository.findById(id).orElseThrow(() -> new GlobalException("El usuario no existe")));
        return userModelDto.getFriends();
    }

    /**
     * Obtiene usuario a partir de un id
     * @param id ID del usuario a encontrar
     * @return Usuario mapeado a UserModelDto
     */
    @Override
    public UserModelDto getUserById(Integer id) {
        Optional<UserModel> userModel = userRepository.findById(id);
        return userModel.map(model -> modelMapper.toUserDTO(model)).orElse(null);
    }

    /**
     * Edita usuario de la bbdd
     * @param userModelDto Usuario de la bbdd
     * @return Usuario actualizado mapeado a UserModelDto
     */
    @Override
    public AuthResponse editUser(UserModelDto userModelDto) {
        UserModel userEdit = userRepository.findById(userModelDto.getId()).orElseThrow(() -> new GlobalException("El usuario no existe"));
        userEdit.setNameuser(userModelDto.getNameuser());
        userEdit.setName(userModelDto.getName());
        if(userModelDto.getImage() != null && !userModelDto.getImage().isEmpty()){
            userEdit.setImage(userModelDto.getImage());
        }

        Map<String, Object> extraClaims = new HashMap<>(); //Declara toda la información que quiere que tenga el token además del correo
        extraClaims.put("idUser", userEdit.getId());
        extraClaims.put("nameuser", userEdit.getNameuser());
        extraClaims.put("name", userEdit.getName());
        extraClaims.put("admin", userEdit.isAdmin());
        extraClaims.put("image", userEdit.getImage());

        String token = jwtService.getTokenFromService(extraClaims, userEdit);
        userRepository.save(userEdit);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    /**
     * Elimina usuario de la bbdd
     * @param id ID del usuario
     * @return true si se elimina, false si no
     */
    @Override
    public boolean deleteUserById(Integer id) {
        UserModel userModel = userRepository.findById(id).orElse(null);
        if(userModel != null){
            userRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }

    @Override
    public boolean existsByEmailIgnoreCase(String email) {
        return userRepository.existsByEmailIgnoreCase(email);
    }

    @Override
    public boolean existsByNameuserIgnoreCase(Integer idUser, String nameuser) {
        UserModel userModel = userRepository.findById(idUser).orElseThrow(() -> new GlobalException("El usuario no existe"));

        if(!userModel.getNameuser().equals(nameuser)){
            return userRepository.existsByNameuserIgnoreCase(nameuser);
        } else{
            return false;
        }
    }

    @Override
    public boolean existsByNameuserIgnoreCaseRegister(String nameuser) {
        return userRepository.existsByNameuserIgnoreCase(nameuser);
    }
}

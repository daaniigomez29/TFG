package com.daniel.tfg.service;

import com.daniel.tfg.auth.AuthResponse;
import com.daniel.tfg.model.dto.UserModelDto;
import com.daniel.tfg.model.dto.UserModelDtoFriends;

import java.util.List;

public interface UserService {
    public List<UserModelDto> getAllUsers();
    public List<UserModelDtoFriends> getAllFriends(Integer id);
    public UserModelDto getUserById(Integer id);
    public AuthResponse editUser(UserModelDto userModelDto);
    public boolean deleteUserById(Integer id);
    public boolean existsByEmailIgnoreCase(String email);
    public boolean existsByNameuserIgnoreCase(Integer idUser, String nameuser);
    public boolean existsByNameuserIgnoreCaseRegister(String nameuser);


}

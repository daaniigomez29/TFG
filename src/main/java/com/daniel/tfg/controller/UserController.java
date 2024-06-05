package com.daniel.tfg.controller;

import com.daniel.tfg.auth.AuthResponse;
import com.daniel.tfg.model.dto.UserModelDto;
import com.daniel.tfg.model.dto.UserModelDtoFriends;

import java.util.List;

public interface UserController {
    public List<UserModelDto> getAllUsers();
    public List<UserModelDtoFriends> getAllFriends(Integer id);
    public UserModelDto getUserById(Integer id);
    public AuthResponse editUser(UserModelDto userModelDto);
    public boolean deleteUserById(Integer id);
    public boolean existsByEmailIgnoreCase(String email);
    public boolean existsByNameuserIgnoreCase(Integer idUser, String nameuser);
}

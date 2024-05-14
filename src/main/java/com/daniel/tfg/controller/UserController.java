package com.daniel.tfg.controller;

import com.daniel.tfg.model.dto.UserModelDto;

import java.util.List;

public interface UserController {
    public List<UserModelDto> getAllUsers();
    public UserModelDto getUserById(Integer id);
    public UserModelDto editUser(UserModelDto userModelDto);
    public boolean deleteUserById(Integer id);
}

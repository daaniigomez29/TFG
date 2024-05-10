package com.daniel.tfg.service;

import com.daniel.tfg.model.dto.UserModelDto;

public interface UserService {
    public UserModelDto getAllUsers();
    public UserModelDto getUserById();
    public UserModelDto addUser(UserModelDto userModelDto);
    public UserModelDto editUser(UserModelDto userModelDto);
    public UserModelDto deleteUserById(Integer id);
}

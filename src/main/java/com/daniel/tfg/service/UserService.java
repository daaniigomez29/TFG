package com.daniel.tfg.service;

import com.daniel.tfg.model.dto.UserModelDto;

import java.util.List;

public interface UserService {
    public List<UserModelDto> getAllUsers();
    public List<UserModelDto> getAllFriends(Integer id);
    public UserModelDto getUserById(Integer id);
    public UserModelDto editUser(UserModelDto userModelDto);
    public boolean deleteUserById(Integer id);
}

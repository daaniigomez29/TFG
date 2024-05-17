package com.daniel.tfg.controller.impl;

import com.daniel.tfg.controller.UserController;
import com.daniel.tfg.model.dto.UserModelDto;
import com.daniel.tfg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Override
    @GetMapping("/users")
    public List<UserModelDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    @GetMapping("/users/{id}/friends")
    public List<UserModelDto> getAllFriends(@PathVariable Integer id) {
        return userService.getAllFriends(id);
    }

    @Override
    @GetMapping("/user/{id}")
    public UserModelDto getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @Override
    @PutMapping("/user/{id}")
    public UserModelDto editUser(@RequestBody UserModelDto userModelDto) {
        return userService.editUser(userModelDto);
    }

    @Override
    @DeleteMapping("user/{id}")
    public boolean deleteUserById(@PathVariable Integer id) {
        return userService.deleteUserById(id);
    }
}

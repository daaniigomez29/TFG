package com.daniel.tfg.controller.impl;

import com.daniel.tfg.auth.AuthResponse;
import com.daniel.tfg.controller.UserController;
import com.daniel.tfg.model.dto.UserModelDto;
import com.daniel.tfg.model.dto.UserModelDtoFriends;
import com.daniel.tfg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que maneja las distintas peticiones relacionadas con usuarios
 */
@RestController
@RequestMapping("/api/v1")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    /**
     * Devuelve todos los usuarios
     */
    @Override
    @GetMapping("/users")
    public List<UserModelDto> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Devuelve los amigos de un usuario
     */
    @Override
    @GetMapping("/users/{id}/friends")
    public List<UserModelDtoFriends> getAllFriends(@PathVariable Integer id) {
        return userService.getAllFriends(id);
    }

    /**
     * Obtiene usuario con ID
     */
    @Override
    @GetMapping("/users/{id}")
    public UserModelDto getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    /**
     * Edita usuario
     */
    @Override
    @PutMapping("/users/{id}")
    public AuthResponse editUser(@RequestBody UserModelDto userModelDto) {
        return userService.editUser(userModelDto);
    }

    /**
     * Elimina usuario
     */
    @Override
    @DeleteMapping("users/{id}")
    public boolean deleteUserById(@PathVariable Integer id) {
        return userService.deleteUserById(id);
    }

    @Override
    @GetMapping("users/existsEmail/{email}")
    public boolean existsByEmailIgnoreCase(@PathVariable String email) {
        return userService.existsByEmailIgnoreCase(email);
    }

    @Override
    @GetMapping("users/existsNameuser/{idUser}/{nameuser}")
    public boolean existsByNameuserIgnoreCase(@PathVariable Integer idUser, @PathVariable String nameuser) {
        return userService.existsByNameuserIgnoreCase(idUser, nameuser);
    }

    @Override
    @GetMapping("users/existsNameuserRegister/{nameuser}")
    public boolean existsByNameuserIgnoreCaseRegister(@PathVariable String nameuser) {
        return userService.existsByNameuserIgnoreCaseRegister(nameuser);
    }
}

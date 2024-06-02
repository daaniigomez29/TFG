package com.daniel.tfg.controller.impl;

import com.daniel.tfg.controller.FriendsController;
import com.daniel.tfg.model.dto.UserModelDto;
import com.daniel.tfg.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que maneja las distintas peticiones relacionadas con amigos
 */
@RestController
@RequestMapping("/api/v1")
public class FriendsControllerImpl implements FriendsController {

    @Autowired
    private FriendsService friendsService;

    /**
     * Añade amigo
     */
    @Override
    @PostMapping("/friends/{idRequest}/{idReceive}")
    public List<UserModelDto> addFriend(@PathVariable Integer idRequest, @PathVariable Integer idReceive) {
        return friendsService.addFriend(idRequest, idReceive);
    }

    /**
     * Elimina amigo
     */
    @Override
    @DeleteMapping("/friends/{idRequest}/{idReceive}")
    public boolean deleteFriend(@PathVariable Integer idRequest, @PathVariable Integer idReceive) {
        return friendsService.deleteFriend(idRequest, idReceive);
    }
}

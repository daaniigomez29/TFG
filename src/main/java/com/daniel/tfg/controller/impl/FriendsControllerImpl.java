package com.daniel.tfg.controller.impl;

import com.daniel.tfg.controller.FriendsController;
import com.daniel.tfg.model.dto.FriendsModelDto;
import com.daniel.tfg.model.dto.UserModelDto;
import com.daniel.tfg.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FriendsControllerImpl implements FriendsController {

    @Autowired
    private FriendsService friendsService;
    @Override
    @GetMapping("/friends/{id}")
    public List<FriendsModelDto> findAllFriendsOfUser(@PathVariable Integer id) {
        return friendsService.findAllFriendsOfUser(id);
    }

    @Override
    public FriendsModelDto getFriendById() {
        return friendsService.getFriendById();
    }

    @Override
    @PostMapping("/friends/{id}")
    public FriendsModelDto addFriend(@RequestBody FriendsModelDto friendsModelDto) {
        return friendsService.addFriend(friendsModelDto);
    }

    @Override
    @PutMapping("/friends/{id}")
    public FriendsModelDto editFriend(@RequestBody FriendsModelDto friendsModelDto) {
        return friendsService.editFriend(friendsModelDto);
    }

    @Override
    @DeleteMapping("/friends/{id}")
    public boolean deleteFriendById(@PathVariable Integer id) {
        return friendsService.deleteFriendById(id);
    }
}

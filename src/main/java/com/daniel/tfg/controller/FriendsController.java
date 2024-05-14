package com.daniel.tfg.controller;

import com.daniel.tfg.model.dto.FriendsModelDto;
import com.daniel.tfg.model.dto.UserModelDto;

import java.util.List;

public interface FriendsController {
    public List<FriendsModelDto> findAllFriendsOfUser(Integer id);
    public FriendsModelDto getFriendById();
    public FriendsModelDto addFriend(FriendsModelDto friendsModelDto);
    public FriendsModelDto editFriend(FriendsModelDto friendsModelDto);
    public boolean deleteFriendById(Integer id);
}

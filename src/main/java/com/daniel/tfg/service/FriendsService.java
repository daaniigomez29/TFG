package com.daniel.tfg.service;

import com.daniel.tfg.model.dto.FriendsModelDto;

import java.util.List;

public interface FriendsService {
    public List<FriendsModelDto> getAllFriendsOfUser();
    public FriendsModelDto getFriendById();
    public FriendsModelDto addFriend(FriendsModelDto friendsModelDto);
    public FriendsModelDto editFriend(FriendsModelDto friendsModelDto);
    public boolean deleteFriendById(Integer id);
}

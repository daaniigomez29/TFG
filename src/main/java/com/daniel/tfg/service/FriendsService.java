package com.daniel.tfg.service;

import com.daniel.tfg.model.dto.FriendsModelDto;

public interface FriendsService {
    public FriendsModelDto getAllFriends();
    public FriendsModelDto getFriendById();
    public FriendsModelDto addFriend(FriendsModelDto friendsModelDto);
    public FriendsModelDto editFriend(FriendsModelDto friendsModelDto);
    public FriendsModelDto deleteFriendById(Integer id);
}

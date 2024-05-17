package com.daniel.tfg.controller;

import com.daniel.tfg.model.dto.UserModelDto;

import java.util.List;

public interface FriendsController {
    public List<UserModelDto> addFriend(Integer idRequest, Integer idReceiver);
    public boolean deleteFriend(Integer idRequest, Integer idReceiver);
}

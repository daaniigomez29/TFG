package com.daniel.tfg.service;

import com.daniel.tfg.model.dto.UserModelDto;

import java.util.List;

public interface FriendsService {
    public List<UserModelDto> addFriend(Integer idRequest, Integer idReceiver);
    public boolean deleteFriend(Integer idRequest, Integer idReceiver);
}

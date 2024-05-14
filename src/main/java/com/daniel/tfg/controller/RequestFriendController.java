package com.daniel.tfg.controller;

import com.daniel.tfg.model.dto.RequestFriendModelDto;
import com.daniel.tfg.model.dto.UserModelDto;

import java.util.List;

public interface RequestFriendController {
    public List<RequestFriendModelDto> findAllRequestsToUser(Integer id);
    public RequestFriendModelDto getRequestFriendByUserId();
    public RequestFriendModelDto addRequestFriend(RequestFriendModelDto requestFriendModelDto);
    public RequestFriendModelDto editRequestFriend(RequestFriendModelDto requestFriendModelDto);
    public boolean deleteRequestFriendById(Integer id);
}

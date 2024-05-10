package com.daniel.tfg.service;

import com.daniel.tfg.model.dto.RequestFriendModelDto;

public interface RequestFriendService {
    public RequestFriendModelDto getAllRequestFriends();
    public RequestFriendModelDto getRequestFriendById();
    public RequestFriendModelDto addRequestFriend(RequestFriendModelDto requestFriendModelDto);
    public RequestFriendModelDto editRequestFriend(RequestFriendModelDto requestFriendModelDto);
    public RequestFriendModelDto deleteRequestFriendById(Integer id);
}

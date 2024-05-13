package com.daniel.tfg.service;

import com.daniel.tfg.model.dto.RequestFriendModelDto;

import java.util.List;

public interface RequestFriendService {
    public List<RequestFriendModelDto> getAllRequestFriends();
    public RequestFriendModelDto getRequestFriendByUserId();
    public RequestFriendModelDto addRequestFriend(RequestFriendModelDto requestFriendModelDto);
    public RequestFriendModelDto editRequestFriend(RequestFriendModelDto requestFriendModelDto);
    public boolean deleteRequestFriendById(Integer id);
}

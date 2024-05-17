package com.daniel.tfg.service;

import com.daniel.tfg.model.RequestFriendModel;
import com.daniel.tfg.model.dto.RequestFriendModelDto;
import com.daniel.tfg.model.dto.UserModelDto;

import java.util.List;
import java.util.Optional;

public interface RequestFriendService {
    public List<RequestFriendModelDto> findAllRequestsToUser(Integer id);
    public RequestFriendModelDto getRequestFriendByUserId();
    public RequestFriendModelDto addRequestFriend(Integer idSender, Integer idReceiver);
    public RequestFriendModelDto editRequestFriend(RequestFriendModelDto requestFriendModelDto);
    public boolean deleteRequestFriendById(Integer id);

    Integer findByUserRequestAndUserReceive(Integer userRequestId, Integer userReceiveId);
}

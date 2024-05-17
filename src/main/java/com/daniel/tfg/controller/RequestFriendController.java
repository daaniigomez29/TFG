package com.daniel.tfg.controller;

import com.daniel.tfg.model.dto.RequestFriendModelDto;
import com.daniel.tfg.model.dto.UserModelDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface RequestFriendController {
    public List<RequestFriendModelDto> findAllRequestsToUser(Integer id);
    public RequestFriendModelDto getRequestFriendByUserId();
    public RequestFriendModelDto addRequestFriend(Integer idSender, Integer idReceiver);
    public RequestFriendModelDto editRequestFriend(RequestFriendModelDto requestFriendModelDto);
    public boolean deleteRequestFriendById(Integer id);
    public Integer findByUserRequestAndUserReceive(Integer userRequestId, Integer userReceiveId);
}

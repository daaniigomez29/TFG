package com.daniel.tfg.service;

import com.daniel.tfg.model.RequestFriendModel;
import com.daniel.tfg.model.dto.RequestFriendModelDto;
import com.daniel.tfg.model.dto.RequestFriendModelDtoWUserReceive;
import com.daniel.tfg.model.dto.UserModelDto;
import org.springframework.data.relational.core.sql.In;

import java.util.List;
import java.util.Optional;

public interface RequestFriendService {
    public List<RequestFriendModelDtoWUserReceive> findAllRequestsToUser(Integer id);
    public RequestFriendModelDto getRequestFriendByUserId();
    public RequestFriendModelDto addRequestFriend(Integer idSender, Integer idReceiver);
    public RequestFriendModelDto editRequestFriend(RequestFriendModelDto requestFriendModelDto);
    public boolean deleteRequestFriend(Integer idSender, Integer idReceiver);

    Integer findByUserRequestAndUserReceive(Integer userRequestId, Integer userReceiveId);
}

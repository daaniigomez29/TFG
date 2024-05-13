package com.daniel.tfg.service.impl;

import com.daniel.tfg.model.dto.RequestFriendModelDto;
import com.daniel.tfg.repository.RequestFriendRepository;
import com.daniel.tfg.repository.UserRepository;
import com.daniel.tfg.service.RequestFriendService;
import com.daniel.tfg.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestFriendServiceImpl implements RequestFriendService {

    @Autowired
    private RequestFriendRepository requestFriendRepository;
    @Autowired
    private Mapper modelMapper;
    @Override
    public List<RequestFriendModelDto> getAllRequestFriends() {
        return null;
    }

    @Override
    public RequestFriendModelDto getRequestFriendByUserId() {
        return null;
    }

    @Override
    public RequestFriendModelDto addRequestFriend(RequestFriendModelDto requestFriendModelDto) {
        return null;
    }

    @Override
    public RequestFriendModelDto editRequestFriend(RequestFriendModelDto requestFriendModelDto) {
        return null;
    }

    @Override
    public boolean deleteRequestFriendById(Integer id) {
        return false;
    }
}

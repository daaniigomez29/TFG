package com.daniel.tfg.service.impl;

import com.daniel.tfg.model.dto.FriendsModelDto;
import com.daniel.tfg.repository.FriendsRepository;
import com.daniel.tfg.repository.UserRepository;
import com.daniel.tfg.service.FriendsService;
import com.daniel.tfg.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsServiceImpl implements FriendsService {

    @Autowired
    private FriendsRepository friendsRepository;
    @Autowired
    private Mapper modelMapper;
    @Override
    public List<FriendsModelDto> getAllFriendsOfUser() {
        return null;
    }

    @Override
    public FriendsModelDto getFriendById() {
        return null;
    }

    @Override
    public FriendsModelDto addFriend(FriendsModelDto friendsModelDto) {
        return null;
    }

    @Override
    public FriendsModelDto editFriend(FriendsModelDto friendsModelDto) {
        return null;
    }

    @Override
    public boolean deleteFriendById(Integer id) {
        return false;
    }
}

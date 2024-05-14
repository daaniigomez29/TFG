package com.daniel.tfg.service.impl;

import com.daniel.tfg.exception.UserInvalidException;
import com.daniel.tfg.model.UserModel;
import com.daniel.tfg.model.dto.FavoriteBooksModelDto;
import com.daniel.tfg.model.dto.FriendsModelDto;
import com.daniel.tfg.model.dto.UserModelDto;
import com.daniel.tfg.repository.FriendsRepository;
import com.daniel.tfg.repository.UserRepository;
import com.daniel.tfg.service.FriendsService;
import com.daniel.tfg.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendsServiceImpl implements FriendsService {

    @Autowired
    private FriendsRepository friendsRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Mapper modelMapper;
    @Override
    public List<FriendsModelDto> findAllFriendsOfUser(Integer id) {
        UserModel userFound = userRepository.findById(id).orElse(null);
        if(userFound != null){
            return friendsRepository.findAllFriendsOfUser(userFound).stream().map(friendsModelDto -> modelMapper.toFriendsDto(friendsModelDto)).collect(Collectors.toList());
        } else {
            throw new UserInvalidException();
        }
    }

    @Override
    public FriendsModelDto getFriendById() {
        return null;
    }

    @Override
    public FriendsModelDto addFriend(FriendsModelDto friendsModelDto) {
        return modelMapper.toFriendsDto(friendsRepository.save(modelMapper.toFriends(friendsModelDto)));
    }

    @Override
    public FriendsModelDto editFriend(FriendsModelDto friendsModelDto) {
        return null;
    }

    @Override
    public boolean deleteFriendById(Integer id) {
        FriendsModelDto friendsModelDto = modelMapper.toFriendsDto(friendsRepository.findById(id).orElse(null));

        if(friendsModelDto != null){
            friendsRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }
}

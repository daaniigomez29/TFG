package com.daniel.tfg.service.impl;

import com.daniel.tfg.exception.UserInvalidException;
import com.daniel.tfg.model.UserModel;
import com.daniel.tfg.model.dto.RequestFriendModelDto;
import com.daniel.tfg.model.dto.UserModelDto;
import com.daniel.tfg.repository.RequestFriendRepository;
import com.daniel.tfg.repository.UserRepository;
import com.daniel.tfg.service.RequestFriendService;
import com.daniel.tfg.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestFriendServiceImpl implements RequestFriendService {

    @Autowired
    private RequestFriendRepository requestFriendRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Mapper modelMapper;
    @Override
    public List<RequestFriendModelDto> findAllRequestsToUser(Integer id) {
        UserModel userFound = userRepository.findById(id).orElse(null);
        if(userFound != null){
            return requestFriendRepository.findAllRequestsToUser(userFound).stream().map(requestFriendModel -> modelMapper.toRequestDto(requestFriendModel)).collect(Collectors.toList());
        } else {
            throw new UserInvalidException();
        }
    }

    @Override
    public RequestFriendModelDto getRequestFriendByUserId() {
        return null;
    }

    @Override
    public RequestFriendModelDto addRequestFriend(RequestFriendModelDto requestFriendModelDto) {
        return modelMapper.toRequestDto(requestFriendRepository.save(modelMapper.toRequest(requestFriendModelDto)));
    }

    @Override
    public RequestFriendModelDto editRequestFriend(RequestFriendModelDto requestFriendModelDto) {
        return null;
    }

    @Override
    public boolean deleteRequestFriendById(Integer id) {
        RequestFriendModelDto requestFriendModelDto = modelMapper.toRequestDto(requestFriendRepository.findById(id).orElse(null));

        if(requestFriendModelDto != null){
            requestFriendRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }
}

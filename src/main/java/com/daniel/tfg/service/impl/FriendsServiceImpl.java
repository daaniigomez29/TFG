package com.daniel.tfg.service.impl;

import com.daniel.tfg.exception.GlobalException;
import com.daniel.tfg.model.UserModel;
import com.daniel.tfg.model.dto.RequestFriendModelDto;
import com.daniel.tfg.model.dto.UserModelDto;
import com.daniel.tfg.repository.RequestFriendRepository;
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
    private UserRepository userRepository;
    @Autowired
    private RequestFriendRepository requestFriendRepository;
    @Autowired
    private Mapper modelMapper;

    @Override
    public List<UserModelDto> addFriend(Integer idRequest, Integer idReceiver) {
        RequestFriendModelDto requestFriendModelDto = modelMapper.toRequestDto(requestFriendRepository.findByUserRequestIdAndUserReceiveId(idRequest, idReceiver).orElseThrow(() -> new GlobalException("La solicitud no existe")));

            UserModel userRequest =  userRepository.findById(idRequest).orElseThrow(() -> new GlobalException("El usuario no existe"));
            UserModel userReceiver = userRepository.findById(idReceiver).orElseThrow(() -> new GlobalException("El usuario no existe"));

            userReceiver.addFriend(userRequest);

            userRepository.save(userReceiver);
            userRepository.save(userRequest);

            requestFriendRepository.delete(modelMapper.toRequest(requestFriendModelDto));

            return userReceiver.getFriends().stream().map(userModel -> modelMapper.toUserDTO(userModel)).collect(Collectors.toList());
    }

    @Override
    public boolean deleteFriend(Integer idRequest, Integer idReceiver) {
        UserModel userModel = userRepository.findById(idRequest).orElseThrow(() -> new GlobalException("El usuario no existe"));
        UserModel friend = userRepository.findById(idReceiver).orElseThrow(() -> new GlobalException("El usuario no existe"));

        if(userModel.getFriends().contains(friend)){
            userModel.removeFriend(friend);

            userRepository.save(userModel);
            userRepository.save(friend);
            return true;
        } else{
            throw new GlobalException("No existe ninguna amistad");
        }
    }
}

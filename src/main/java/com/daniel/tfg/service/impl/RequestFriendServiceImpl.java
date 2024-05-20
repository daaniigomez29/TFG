package com.daniel.tfg.service.impl;

import com.daniel.tfg.exception.GlobalException;
import com.daniel.tfg.exception.UserInvalidException;
import com.daniel.tfg.model.RequestFriendModel;
import com.daniel.tfg.model.UserModel;
import com.daniel.tfg.model.dto.RequestFriendModelDto;
import com.daniel.tfg.model.dto.RequestFriendModelDtoWUserReceive;
import com.daniel.tfg.model.dto.UserModelDto;
import com.daniel.tfg.repository.RequestFriendRepository;
import com.daniel.tfg.repository.UserRepository;
import com.daniel.tfg.service.RequestFriendService;
import com.daniel.tfg.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public List<RequestFriendModelDtoWUserReceive> findAllRequestsToUser(Integer id) {
        UserModel userFound = userRepository.findById(id).orElse(null);
        if(userFound != null){
            return requestFriendRepository.findAllRequestsToUser(userFound).stream().map(requestFriendModel -> modelMapper.toRequestDtoWUserReceive(requestFriendModel)).collect(Collectors.toList());
        } else {
            throw new UserInvalidException();
        }
    }

    @Override
    public RequestFriendModelDto getRequestFriendByUserId() {
        return null;
    }

    @Override
    public RequestFriendModelDto addRequestFriend(Integer idSender, Integer idReceiver) {
        UserModelDto userSender = modelMapper.toUserDTO(userRepository.findById(idSender).orElseThrow(UserInvalidException::new));
        UserModelDto userReceiver = modelMapper.toUserDTO(userRepository.findById(idReceiver).orElseThrow(UserInvalidException::new));

        RequestFriendModel requestFriendModelFound = requestFriendRepository.findByUserRequestIdAndUserReceiveId(idSender, idReceiver).orElse(null);

        RequestFriendModel requestFriendModel2 = requestFriendRepository.findByUserRequestIdAndUserReceiveId(idReceiver, idSender).orElse(null); //Esta búsqueda sirve para comprobar que ninguno de los 2 usuarios ha enviado una solicitud

        if(requestFriendModelFound == null && requestFriendModel2 == null && !userSender.getEmail().equals(userReceiver.getEmail())){
            userSender.getFriends().forEach(userModelDtoFriends -> {
                if (userModelDtoFriends.equals(modelMapper.toUserDTOFriend(userReceiver))){
                    throw new GlobalException("El usuario ya ha sido añadido como amigo");
                }
            });

            RequestFriendModel requestFriendModel = new RequestFriendModel();
            requestFriendModel.setUserRequest(modelMapper.toUser(userSender));
            requestFriendModel.setUserReceive(modelMapper.toUser(userReceiver));

            return modelMapper.toRequestDto(requestFriendRepository.save(requestFriendModel));
        } else{
            throw new GlobalException("La solicitud ya ha sido enviada");
        }
    }
    @Override
    public RequestFriendModelDto editRequestFriend(RequestFriendModelDto requestFriendModelDto) {
        return null;
    }

    @Override
    public boolean deleteRequestFriend(Integer idSender, Integer idReceiver) {
        RequestFriendModel requestFriendModel = requestFriendRepository.findByUserRequestIdAndUserReceiveId(idSender, idReceiver).orElse(null);

        if(requestFriendModel != null){
            requestFriendRepository.deleteById(requestFriendModel.getId());
            return true;
        } else{
            return false;
        }
    }

    @Override
    public Integer findByUserRequestAndUserReceive(Integer userRequestId, Integer userReceiveId) {
       RequestFriendModel requestFriendModel = requestFriendRepository.findByUserRequestIdAndUserReceiveId(userRequestId, userReceiveId)
                .orElseThrow(() -> new GlobalException("La solicitud no existe"));

        return requestFriendModel.getId();
    }
}

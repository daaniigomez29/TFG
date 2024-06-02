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
    @Autowired //Inyecta dependencia de la clase
    private UserRepository userRepository; //Repositorio de la bbdd de usuarios
    @Autowired
    private RequestFriendRepository requestFriendRepository; //Repositorio de la bbdd de petición de amistades
    @Autowired
    private Mapper modelMapper;

    /**
     * Acepta la petición del usuario y se añade como amigos
     * @param idRequest ID del usuario que envía la solicitud
     * @param idReceiver ID del usuario que recibe la solicitud
     * @return Lista de amigos del usuario que acepta la solicitud (el que la recibe)
     */
    @Override
    public List<UserModelDto> addFriend(Integer idRequest, Integer idReceiver) {
        RequestFriendModelDto requestFriendModelDto = modelMapper.toRequestDto(requestFriendRepository.findByUserRequestIdAndUserReceiveId(idRequest, idReceiver).orElseThrow(() -> new GlobalException("La solicitud no existe")));

            UserModel userRequest =  userRepository.findById(idRequest).orElseThrow(() -> new GlobalException("El usuario no existe"));
            UserModel userReceiver = userRepository.findById(idReceiver).orElseThrow(() -> new GlobalException("El usuario no existe"));

            userReceiver.addFriend(userRequest); //Añade al usuario el amigo en la tabla de la entidad UserModel

            userRepository.save(userReceiver); //Guarda al usuario con el amigo añadido en la bbdd
            userRepository.save(userRequest); //Guarda al usuario con el amigo añadido en la bbdd

            requestFriendRepository.delete(modelMapper.toRequest(requestFriendModelDto)); //Elimina la petición hecha en la bbdd

            return userReceiver.getFriends().stream().map(userModel -> modelMapper.toUserDTO(userModel)).collect(Collectors.toList());
    }

    /**
     * Elimina a un amigo de la lista
     * @param idRequest ID del usuario que envio la peticion
     * @param idReceiver ID del usuario que recibio la peticion
     * @return true si se elimina, false si no
     */
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

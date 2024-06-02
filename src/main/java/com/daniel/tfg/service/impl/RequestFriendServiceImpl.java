package com.daniel.tfg.service.impl;

import com.daniel.tfg.exception.GlobalException;
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
import java.util.stream.Collectors;

@Service
public class RequestFriendServiceImpl implements RequestFriendService {

    @Autowired //Inyecta dependencia de la clase
    private RequestFriendRepository requestFriendRepository; //Repositorio de la bbdd de petición de amistades
    @Autowired
    private UserRepository userRepository; //Repositorio de la bbdd de usuarios
    @Autowired
    private Mapper modelMapper;

    /**
     * Encuentra todas las peticiones de amistad que se le han hecho a un usuario
     * @param id ID del usuario
     * @return Lista con todas las peticiones que se le han enviado al usuario mapeando a RequestFriendModelDtoWUserReceive, este objeto solo contiene el UserReceive y no el UserRequest
     */
    @Override
    public List<RequestFriendModelDtoWUserReceive> findAllRequestsToUser(Integer id) {
        UserModel userFound = userRepository.findById(id).orElse(null);
        if(userFound != null){
            return requestFriendRepository.findAllRequestsToUser(userFound).stream().map(requestFriendModel -> modelMapper.toRequestDtoWUserReceive(requestFriendModel)).collect(Collectors.toList());
        } else {
            throw new GlobalException("El usuario no existe");
        }
    }

    @Override
    public RequestFriendModelDto getRequestFriendByUserId() {
        return null;
    }

    /**
     * Envía una peticion de amistad de un usuario
     * @param idSender ID del usuario que envia la peticion
     * @param idReceiver ID del usuario que recibe la peticion
     * @return Peticion mapeada a RequestFriendModelDto
     */
    @Override
    public RequestFriendModelDto addRequestFriend(Integer idSender, Integer idReceiver) {
        UserModelDto userSender = modelMapper.toUserDTO(userRepository.findById(idSender).orElseThrow(() -> new GlobalException("El usuario no existe"))); //Comprueba que el usuario existe
        UserModelDto userReceiver = modelMapper.toUserDTO(userRepository.findById(idReceiver).orElseThrow(() -> new GlobalException("El usuario no existe"))); //Comprueba que el usuario existe

        RequestFriendModel requestFriendModelFound = requestFriendRepository.findByUserRequestIdAndUserReceiveId(idSender, idReceiver).orElse(null); //Comprueba que el usuario no haya enviado una solicitud anteriormente a ese usuario

        RequestFriendModel requestFriendModel2 = requestFriendRepository.findByUserRequestIdAndUserReceiveId(idReceiver, idSender).orElse(null); //Esta búsqueda sirve para comprobar que ninguno de los 2 usuarios ha enviado una solicitud

        if(requestFriendModelFound == null && requestFriendModel2 == null && !userSender.getEmail().equals(userReceiver.getEmail())){ //Comprueba que request1 y 2 sean null y que el usuario que envia la peticion no es a el mismo
            userSender.getFriends().forEach(userModelDtoFriends -> { //Comprueba que los usuarios no sean amigos
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

    /**
     * Elimina la peticion de amistad
     * @param idSender //ID del usuario que envio la solicitud
     * @param idReceiver //ID del usuario que recibio la solicitud
     * @return true si se elimina, false si no
     */
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

    /**
     * Encuentra peticion de amistad por el id del usuario que envio y el que recibio la solicitud
     * @param userRequestId ID del usuario que envio la peticion
     * @param userReceiveId ID del usuario que recivio la peticion
     * @return id de la peticion
     */
    @Override
    public Integer findByUserRequestAndUserReceive(Integer userRequestId, Integer userReceiveId) {
       RequestFriendModel requestFriendModel = requestFriendRepository.findByUserRequestIdAndUserReceiveId(userRequestId, userReceiveId)
                .orElseThrow(() -> new GlobalException("La solicitud no existe"));

        return requestFriendModel.getId();
    }
}

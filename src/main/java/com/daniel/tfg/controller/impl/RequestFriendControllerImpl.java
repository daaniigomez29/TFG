package com.daniel.tfg.controller.impl;

import com.daniel.tfg.controller.RequestFriendController;
import com.daniel.tfg.model.dto.RequestFriendModelDto;
import com.daniel.tfg.model.dto.RequestFriendModelDtoWUserReceive;
import com.daniel.tfg.model.dto.UserModelDto;
import com.daniel.tfg.service.RequestFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que maneja las distintas peticiones relacionadas con peticiones de amistad
 */
@RestController
@RequestMapping("/api/v1")
public class RequestFriendControllerImpl implements RequestFriendController {

    @Autowired
    private RequestFriendService requestFriendService;

    /**
     * Obtiene peticiones enviadas a un usuario
     */
    @Override
    @GetMapping("/requests/{id}")
    public List<RequestFriendModelDtoWUserReceive> findAllRequestsToUser(@PathVariable Integer id) {
        return requestFriendService.findAllRequestsToUser(id);
    }

    @Override
    public RequestFriendModelDto getRequestFriendByUserId() {
        return requestFriendService.getRequestFriendByUserId();
    }

    /**
     * Crea peticion de usuario
     */
    @Override
    @PostMapping("/requests/{idSender}/{idReceiver}")
    public RequestFriendModelDto addRequestFriend(@PathVariable Integer idSender, @PathVariable Integer idReceiver) {
        return requestFriendService.addRequestFriend(idSender, idReceiver);
    }

    @Override
    @PutMapping("/requests/{id}")
    public RequestFriendModelDto editRequestFriend(@RequestBody RequestFriendModelDto requestFriendModelDto) {
        return requestFriendService.editRequestFriend(requestFriendModelDto);
    }

    /**
     * Elimina peticion de usuario
     */
    @Override
    @DeleteMapping("/requests/{idSender}/{idReceiver}")
    public boolean deleteRequestFriend(@PathVariable Integer idSender, @PathVariable Integer idReceiver) {
        return requestFriendService.deleteRequestFriend(idSender, idReceiver);
    }

    /**
     * Encuentra con ID  peticion de usuario
     */
    @Override
    @GetMapping("/requestId/{userRequestId}/{userReceiveId}")
    public Integer findByUserRequestAndUserReceive(@PathVariable Integer userRequestId, @PathVariable Integer userReceiveId) {
        return requestFriendService.findByUserRequestAndUserReceive(userRequestId, userReceiveId);
    }
}

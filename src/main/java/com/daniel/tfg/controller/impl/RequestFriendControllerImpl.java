package com.daniel.tfg.controller.impl;

import com.daniel.tfg.controller.RequestFriendController;
import com.daniel.tfg.model.dto.RequestFriendModelDto;
import com.daniel.tfg.model.dto.RequestFriendModelDtoWUserReceive;
import com.daniel.tfg.model.dto.UserModelDto;
import com.daniel.tfg.service.RequestFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RequestFriendControllerImpl implements RequestFriendController {

    @Autowired
    private RequestFriendService requestFriendService;
    @Override
    @GetMapping("/requests/{id}")
    public List<RequestFriendModelDtoWUserReceive> findAllRequestsToUser(@PathVariable Integer id) {
        return requestFriendService.findAllRequestsToUser(id);
    }

    @Override
    public RequestFriendModelDto getRequestFriendByUserId() {
        return requestFriendService.getRequestFriendByUserId();
    }

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

    @Override
    @DeleteMapping("/requests/{idSender}/{idReceiver}")
    public boolean deleteRequestFriend(@PathVariable Integer idSender, @PathVariable Integer idReceiver) {
        return requestFriendService.deleteRequestFriend(idSender, idReceiver);
    }

    @Override
    @GetMapping("/requestId/{userRequestId}/{userReceiveId}")
    public Integer findByUserRequestAndUserReceive(@PathVariable Integer userRequestId, @PathVariable Integer userReceiveId) {
        return requestFriendService.findByUserRequestAndUserReceive(userRequestId, userReceiveId);
    }
}

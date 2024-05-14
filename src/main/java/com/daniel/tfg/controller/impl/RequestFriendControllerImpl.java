package com.daniel.tfg.controller.impl;

import com.daniel.tfg.controller.RequestFriendController;
import com.daniel.tfg.model.dto.RequestFriendModelDto;
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
    public List<RequestFriendModelDto> findAllRequestsToUser(@PathVariable Integer id) {
        return requestFriendService.findAllRequestsToUser(id);
    }

    @Override
    public RequestFriendModelDto getRequestFriendByUserId() {
        return requestFriendService.getRequestFriendByUserId();
    }

    @Override
    @PostMapping("/requests")
    public RequestFriendModelDto addRequestFriend(@RequestBody RequestFriendModelDto requestFriendModelDto) {
        return requestFriendService.addRequestFriend(requestFriendModelDto);
    }

    @Override
    @PutMapping("/requests/{id}")
    public RequestFriendModelDto editRequestFriend(@RequestBody RequestFriendModelDto requestFriendModelDto) {
        return requestFriendService.editRequestFriend(requestFriendModelDto);
    }

    @Override
    @DeleteMapping("/requests/{id}")
    public boolean deleteRequestFriendById(@PathVariable Integer id) {
        return requestFriendService.deleteRequestFriendById(id);
    }
}

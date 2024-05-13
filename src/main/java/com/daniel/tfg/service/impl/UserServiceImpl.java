package com.daniel.tfg.service.impl;

import com.daniel.tfg.model.UserModel;
import com.daniel.tfg.model.dto.UserModelDto;
import com.daniel.tfg.repository.UserRepository;
import com.daniel.tfg.service.UserService;
import com.daniel.tfg.util.Mapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Mapper modelMapper;
    @Override
    public List<UserModelDto> getAllUsers() {
        return userRepository.findAll().stream().map(userModel -> modelMapper.toUserDTO(userModel)).collect(Collectors.toList());
    }

    @Override
    public UserModelDto getUserById(Integer id) {
        Optional<UserModel> userModel = userRepository.findById(id);
        return userModel.map(model -> modelMapper.toUserDTO(model)).orElse(null);
    }

    @Override
    public UserModelDto editUser(UserModelDto userModelDto) {
        return modelMapper.toUserDTO(userRepository.save(modelMapper.toUser(userModelDto)));
    }

    @Override
    public boolean deleteUserById(Integer id) {
        UserModel userModel = userRepository.findById(id).orElse(null);
        if(userModel != null){
            userRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }
}

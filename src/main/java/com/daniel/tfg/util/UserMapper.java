package com.daniel.tfg.util;


import com.daniel.tfg.model.UserModel;
import com.daniel.tfg.model.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;


    public UserDTO toUserDTO(UserModel user){
        return modelMapper.map(user, UserDTO.class);
    }

    public UserModel toUser(UserDTO userDTO){
        return modelMapper.map(userDTO, UserModel.class);
    }
}
package com.daniel.tfg.util;


import com.daniel.tfg.entity.dto.UserDTO;
import com.daniel.tfg.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;


    public UserDTO toUserDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    }

    public User toUser(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }
}

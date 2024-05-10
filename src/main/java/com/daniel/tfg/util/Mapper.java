package com.daniel.tfg.util;


import com.daniel.tfg.model.UserModel;
import com.daniel.tfg.model.dto.UserModelDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mapper {

    private final ModelMapper modelMapper;


    public UserModelDto toUserDTO(UserModel user){
        return modelMapper.map(user, UserModelDto.class);
    }

    public UserModel toUser(UserModelDto userDTO){
        return modelMapper.map(userDTO, UserModel.class);
    }
}

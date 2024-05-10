package com.daniel.tfg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestFriendModelDto {
    private Integer id;
    private UserModelDto userModelDtoRequest;
    private UserModelDto userModelDtoReceive;
}

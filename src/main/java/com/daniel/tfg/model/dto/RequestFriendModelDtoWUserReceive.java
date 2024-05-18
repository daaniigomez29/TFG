package com.daniel.tfg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestFriendModelDtoWUserReceive {
    private Integer id;
    private UserModelDto userModelDtoRequest;
}

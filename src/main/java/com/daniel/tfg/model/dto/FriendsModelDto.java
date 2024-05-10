package com.daniel.tfg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FriendsModelDto {
    private Integer id;
    private UserModelDto userModelDto1;
    private UserModelDto userModelDto2;
}

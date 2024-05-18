package com.daniel.tfg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModelDtoFriends {
    private Integer id;
    private String email;
    private String nameuser;
    private String name;
    private String image;
    private boolean admin;
}

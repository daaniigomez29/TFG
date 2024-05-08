package com.daniel.tfg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String email;
    private String username;
    private String name;
    private boolean admin;
    private String token;
}

package com.daniel.tfg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FavoriteBooksModelDto {
    private Integer id;
    private UserModelDto userModelDto;
    private BookModelDto bookModelDto;
}

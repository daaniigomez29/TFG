package com.daniel.tfg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FavoriteBooksModelDtoWUser {
    private Integer id;
    private BookModelDto bookModelDto;
}

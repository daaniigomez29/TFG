package com.daniel.tfg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookModelDto {
    private Integer id;
    private String name;
    private String nameAuthor;
    private String editorial;
    private String synopsis;
    private String genre;
    private String image;
}

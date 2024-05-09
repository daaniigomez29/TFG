package com.daniel.tfg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Books")
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Column(name = "name_author")
    private String nameAuthor;
    private String editorial;
    private String synopsis;
    private String genre;
    private String image;


    @OneToMany(mappedBy = "bookModel", cascade = CascadeType.ALL)
    List<FavoriteBooksModel> favoriteBooksModels;


}

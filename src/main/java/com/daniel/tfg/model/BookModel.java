package com.daniel.tfg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor //Constructor con todos los argumentos
@NoArgsConstructor //Constructor sin argumentos
@Data //Getter y Setter
@Entity //Tabla en la bbdd
@Table(name = "Books") //Nombre de la tabla
public class BookModel {

    @Id //ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generación automática de id
    private Integer id;
    private String name; //Nombre del libro

    @Column(name = "name_author") //Nombre de la columna en la bbdd
    private String nameAuthor; //Autor del libro
    private String editorial; //Editorial del libro
    private String synopsis; //Sinopsis del libro
    private String genre; //Género del libro
    private String image; //Imagen del libro


    @OneToMany(mappedBy = "bookModel", cascade = CascadeType.ALL)
    List<FavoriteBooksModel> favoriteBooksModels; //Libros favoritos relacionados con el usuario


}

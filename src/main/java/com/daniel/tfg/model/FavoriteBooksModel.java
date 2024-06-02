package com.daniel.tfg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor //Constructor con todos los argumentos
@NoArgsConstructor //Constructor sin argumentos
@Data //Getter y Setter
@Entity //Tabla de la bbdd
@Table(name = "Favorite_Books") //Nombre de la tabla
public class FavoriteBooksModel {

    @Id //ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generación automática de id
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private UserModel userModel; //Usuario que asigna el libro favorito

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_book")
    private BookModel bookModel; //Libro favorito que asigna el usuario

}

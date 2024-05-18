package com.daniel.tfg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Favorite_Books")
//@IdClass(IdFavoriteBooks.class)
public class FavoriteBooksModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private UserModel userModel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_book")
    private BookModel bookModel;

}

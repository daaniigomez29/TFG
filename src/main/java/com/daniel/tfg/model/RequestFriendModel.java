package com.daniel.tfg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor //Constructor con todos los argumentos
@NoArgsConstructor //Constructor sin argumentos
@Data //Getter y Setter
@Entity //Tabla de la bbdd
@Table(name = "Request_Friend") //Nombre de la tabla
public class RequestFriendModel {

    @Id //ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generación automática de ID
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_userRequest")
    private UserModel userRequest; //Usuario que envía la solicitud

    @ManyToOne
    @JoinColumn(name = "id_userReceive")
    private UserModel userReceive; //Usuario que recibe la solicitud

}

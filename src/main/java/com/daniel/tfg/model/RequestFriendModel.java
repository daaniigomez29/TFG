package com.daniel.tfg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Request_Friend")
public class RequestFriendModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_userRequest")
    private UserModel userRequest;

    @ManyToOne
    @JoinColumn(name = "id_userReceive")
    private UserModel userReceive;

}

package com.daniel.tfg.model;

import com.daniel.tfg.exception.GlobalException;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;

@Data //Getter y Setter
@Builder
@NoArgsConstructor //Constructor sin argumentos
@AllArgsConstructor //Constructor con todos los argumentos
@Entity //Tabla de la bbdd
@Table(name = "user_books", uniqueConstraints = {@UniqueConstraint(columnNames = {"username", "email"})}) //Nombre de la tabla y declaración de valores únicos
public class UserModel implements UserDetails {

    @Id //ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generación automática de id
    private Integer id;
    @Email(message = "El email debe ser válido") //Validador que comprueba que el email sea válido
    private String email;
    @Column(nullable = false) //La columna nameuser no puede ser nula
    private String nameuser; //Nombre de usuario
    private String password; //Contraseña del usuario
    private String name; //Nombre del usuario
    private String image; //Imagen de perfil del usuario
    private boolean admin; //Declara si es admin o no


    /** Relaciones tabla solicitudes amistad */
    @OneToMany(mappedBy = "userRequest", cascade = CascadeType.ALL)
    List<RequestFriendModel> requestFriendModelList; //Lista de solicitudes que se ha enviado

    @OneToMany(mappedBy = "userReceive", cascade = CascadeType.ALL)
    List<RequestFriendModel> ReceiveFriendModelList; //Lista de solicitudes que se ha recibido


    /** Relaciones tabla Friends */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "friends", //Nombre de la tabla
            joinColumns = @JoinColumn(name = "user_id"), //Columna de usuario
            inverseJoinColumns = @JoinColumn(name = "friend_id") //Columna de amigo del usuario
    )
    private List<UserModel> friends; //Lista de amigos del usuario

    /** Relaciones tabla Libros Favoritos */
    @OneToMany(mappedBy = "userModel", cascade = CascadeType.ALL)
    List<FavoriteBooksModel> favoriteBooksModelsList; //Lista de libros favoritos del usuario


    /**
     * Añade un amigo a la lista del usuario y a la del usuario que le envió la solicitud
     * @param friend Usuario que le envió la solicitud
     */
    public void addFriend(UserModel friend) {
        if (!this.friends.contains(friend)) {
            this.friends.add(friend);
            friend.getFriends().add(this);
        } else{
            throw new GlobalException("El usuario ya ha sido añadido como amigo");
        }
    }

    /**
     * Elimina al amigo de la lista de amigos
     * @param friend Usuario que quiere eliminar de la lista
     */
    public void removeFriend(UserModel friend){
        if(this.friends.contains(friend)){
            this.friends.remove(friend);
            friend.getFriends().remove(this);
        } else{
            throw new GlobalException("El usuario ya ha sido eliminado como amigo");
        }
    }

    /** Métodos para manejar el inicio de sesión de usuario */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

package com.daniel.tfg.model;

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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_books", uniqueConstraints = {@UniqueConstraint(columnNames = {"username", "email"})})
public class UserModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Email(message = "El email debe ser válido")
    private String email;
    @Column(nullable = false)
    private String nameuser;
    private String password;
    private String name;
    private String image;
    private boolean admin;


    /** Relaciones tabla solicitudes amistad */
    @OneToMany(mappedBy = "userRequest", cascade = CascadeType.ALL)
    List<RequestFriendModel> requestFriendModelList;

    @OneToMany(mappedBy = "userReceive", cascade = CascadeType.ALL)
    List<RequestFriendModel> ReceiveFriendModelList;


    /** Relaciones tabla Friends */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "friends",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<UserModel> friends;

    /** Relaciones tabla Libros Favoritos */
    @OneToMany(mappedBy = "userModel", cascade = CascadeType.ALL)
    List<FavoriteBooksModel> favoriteBooksModelsList;


    public void addFriend(UserModel friend) {
        if (!this.friends.contains(friend)) {
            this.friends.add(friend);
            friend.getFriends().add(this);
        }
    }

    public void removeFriend(UserModel friend){
        if(this.friends.contains(friend)){
            this.friends.remove(friend);
            friend.removeFriend(this);
        }
    }

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

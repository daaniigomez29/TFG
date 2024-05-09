package com.daniel.tfg.repository;

import com.daniel.tfg.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByEmail(String email);
}

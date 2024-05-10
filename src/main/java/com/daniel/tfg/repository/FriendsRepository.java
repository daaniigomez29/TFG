package com.daniel.tfg.repository;

import com.daniel.tfg.model.FriendsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsRepository extends JpaRepository<FriendsModel, Integer> {
}

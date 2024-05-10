package com.daniel.tfg.repository;

import com.daniel.tfg.model.FavoriteBooksModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteBooksRepository extends JpaRepository<FavoriteBooksModel, Integer> {
}

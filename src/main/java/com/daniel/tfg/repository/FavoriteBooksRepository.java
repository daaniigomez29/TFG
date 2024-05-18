package com.daniel.tfg.repository;

import com.daniel.tfg.model.FavoriteBooksModel;
import com.daniel.tfg.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteBooksRepository extends JpaRepository<FavoriteBooksModel, Integer> {


    @Query("SELECT b FROM FavoriteBooksModel b WHERE b.userModel = :user")
    List<FavoriteBooksModel> obtainAllFavoriteBooks(@Param("user") UserModel userModel);

    Optional<FavoriteBooksModel> findByUserModelIdAndBookModelId(Integer userId, Integer bookId);

}

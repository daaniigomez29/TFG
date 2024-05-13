package com.daniel.tfg.repository;

import com.daniel.tfg.model.BookModel;
import com.daniel.tfg.model.dto.FavoriteBooksModelDto;
import com.daniel.tfg.model.dto.UserModelDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer> {

    @Query("SELECT b FROM FavoriteBooksModel WHERE b.userModel = :user")
    List<FavoriteBooksModelDto> obtainAllFavoriteBooks(@Param("user") UserModelDto userModelDto);
}

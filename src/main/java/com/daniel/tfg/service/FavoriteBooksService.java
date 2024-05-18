package com.daniel.tfg.service;

import com.daniel.tfg.model.FavoriteBooksModel;
import com.daniel.tfg.model.dto.FavoriteBooksModelDto;
import com.daniel.tfg.model.dto.UserModelDto;

import java.util.List;
import java.util.Optional;

public interface FavoriteBooksService {
    List<FavoriteBooksModelDto> getAllFavoriteBooksOfUser(Integer id);
    FavoriteBooksModelDto getFavoriteBookById();
    FavoriteBooksModelDto addFavoriteBooks(Integer userId, Integer bookId);
    FavoriteBooksModelDto editFavoriteBooks(FavoriteBooksModelDto favoriteBooksModelDto);
    boolean deleteFavoriteBooksById(Integer userId, Integer bookId);
    Integer findByUserIdAndBookId(Integer userId, Integer bookId);

}

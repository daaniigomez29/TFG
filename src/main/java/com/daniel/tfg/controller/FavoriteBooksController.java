package com.daniel.tfg.controller;

import com.daniel.tfg.model.dto.FavoriteBooksModelDto;
import com.daniel.tfg.model.dto.FavoriteBooksModelDtoWUser;
import com.daniel.tfg.model.dto.UserModelDto;

import java.util.List;

public interface FavoriteBooksController {
    List<FavoriteBooksModelDtoWUser> getAllFavoriteBooksOfUser(Integer id);
    FavoriteBooksModelDto getFavoriteBookById();
    FavoriteBooksModelDto addFavoriteBooks(Integer userId, Integer bookId);
    FavoriteBooksModelDto editFavoriteBooks(FavoriteBooksModelDto favoriteBooksModelDto);
    boolean deleteFavoriteBooksById(Integer userId, Integer bookId);
    Integer findByUserIdAndBookId(Integer userId, Integer bookId);

}

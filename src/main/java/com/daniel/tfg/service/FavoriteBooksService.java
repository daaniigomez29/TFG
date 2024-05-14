package com.daniel.tfg.service;

import com.daniel.tfg.model.dto.FavoriteBooksModelDto;
import com.daniel.tfg.model.dto.UserModelDto;

import java.util.List;

public interface FavoriteBooksService {
    public List<FavoriteBooksModelDto> getAllFavoriteBooksOfUser(Integer id);
    public FavoriteBooksModelDto getFavoriteBookById();
    public FavoriteBooksModelDto addFavoriteBooks(FavoriteBooksModelDto favoriteBooksModelDto);
    public FavoriteBooksModelDto editFavoriteBooks(FavoriteBooksModelDto favoriteBooksModelDto);
    public boolean deleteFavoriteBooksById(Integer id);
}

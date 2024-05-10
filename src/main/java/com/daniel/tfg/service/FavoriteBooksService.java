package com.daniel.tfg.service;

import com.daniel.tfg.model.dto.FavoriteBooksModelDto;

public interface FavoriteBooksService {
    public FavoriteBooksModelDto getAllFavoriteBooks();
    public FavoriteBooksModelDto getFavoriteBookById();
    public FavoriteBooksModelDto addFavoriteBooks(FavoriteBooksModelDto favoriteBooksModelDto);
    public FavoriteBooksModelDto editFavoriteBooks(FavoriteBooksModelDto favoriteBooksModelDto);
    public FavoriteBooksModelDto deleteFavoriteBooksById(Integer id);
}

package com.daniel.tfg.service;

import com.daniel.tfg.model.dto.FavoriteBooksModelDto;

import java.util.List;

public interface FavoriteBooksService {
    public List<FavoriteBooksModelDto> getAllFavoriteBooks();
    public FavoriteBooksModelDto getFavoriteBookById();
    public FavoriteBooksModelDto addFavoriteBooks(FavoriteBooksModelDto favoriteBooksModelDto);
    public FavoriteBooksModelDto editFavoriteBooks(FavoriteBooksModelDto favoriteBooksModelDto);
    public boolean deleteFavoriteBooksById(Integer id);
}

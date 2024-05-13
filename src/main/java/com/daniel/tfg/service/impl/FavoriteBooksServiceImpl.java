package com.daniel.tfg.service.impl;

import com.daniel.tfg.model.dto.FavoriteBooksModelDto;
import com.daniel.tfg.repository.FavoriteBooksRepository;
import com.daniel.tfg.service.FavoriteBooksService;
import com.daniel.tfg.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteBooksServiceImpl implements FavoriteBooksService {

    @Autowired
    private FavoriteBooksRepository favoriteBooksRepository;
    @Autowired
    private Mapper modelMapper;
    @Override
    public List<FavoriteBooksModelDto> getAllFavoriteBooks() {
        return null;
    }

    @Override
    public FavoriteBooksModelDto getFavoriteBookById() {
        return null;
    }

    @Override
    public FavoriteBooksModelDto addFavoriteBooks(FavoriteBooksModelDto favoriteBooksModelDto) {
        return null;
    }

    @Override
    public FavoriteBooksModelDto editFavoriteBooks(FavoriteBooksModelDto favoriteBooksModelDto) {
        return null;
    }

    @Override
    public boolean deleteFavoriteBooksById(Integer id) {
        return false;
    }
}

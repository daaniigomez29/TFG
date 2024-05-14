package com.daniel.tfg.controller.impl;

import com.daniel.tfg.controller.FavoriteBooksController;
import com.daniel.tfg.model.dto.FavoriteBooksModelDto;
import com.daniel.tfg.model.dto.UserModelDto;
import com.daniel.tfg.service.FavoriteBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FavoriteBooksControllerImpl implements FavoriteBooksController {

    @Autowired
    private FavoriteBooksService favoriteBooksService;
    @Override
    @GetMapping("/favorites/{id}")
    public List<FavoriteBooksModelDto> getAllFavoriteBooksOfUser(@PathVariable Integer id) {
        return favoriteBooksService.getAllFavoriteBooksOfUser(id);
    }

    @Override
    public FavoriteBooksModelDto getFavoriteBookById() {
        return favoriteBooksService.getFavoriteBookById();
    }

    @Override
    @PostMapping("/favorites")
    public FavoriteBooksModelDto addFavoriteBooks(@RequestBody FavoriteBooksModelDto favoriteBooksModelDto) {
        return favoriteBooksService.addFavoriteBooks(favoriteBooksModelDto);
    }

    @Override
    @PutMapping("/favorites/{id}")
    public FavoriteBooksModelDto editFavoriteBooks(@RequestBody FavoriteBooksModelDto favoriteBooksModelDto) {
        return favoriteBooksService.editFavoriteBooks(favoriteBooksModelDto);
    }

    @Override
    @DeleteMapping("/favorites/{id}")
    public boolean deleteFavoriteBooksById(@PathVariable Integer id) {
        return favoriteBooksService.deleteFavoriteBooksById(id);
    }
}

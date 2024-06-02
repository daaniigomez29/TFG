package com.daniel.tfg.controller.impl;

import com.daniel.tfg.controller.FavoriteBooksController;
import com.daniel.tfg.model.dto.FavoriteBooksModelDto;
import com.daniel.tfg.model.dto.FavoriteBooksModelDtoWUser;
import com.daniel.tfg.model.dto.UserModelDto;
import com.daniel.tfg.service.FavoriteBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que maneja las distintas peticiones relacionadas con libros favoritos
 */
@RestController
@RequestMapping("/api/v1")
public class FavoriteBooksControllerImpl implements FavoriteBooksController {

    @Autowired
    private FavoriteBooksService favoriteBooksService;

    /**
     * Obtiene todos los libros favoritos de un usuario
     */
    @Override
    @GetMapping("/favorites/{id}")
    public List<FavoriteBooksModelDtoWUser> getAllFavoriteBooksOfUser(@PathVariable Integer id) {
        return favoriteBooksService.getAllFavoriteBooksOfUser(id);
    }

    @Override
    public FavoriteBooksModelDto getFavoriteBookById() {
        return favoriteBooksService.getFavoriteBookById();
    }

    /**
     * Añade libro favorito de un usuario
     */
    @Override
    @PostMapping("/favorites/{userId}/{bookId}")
    public FavoriteBooksModelDto addFavoriteBooks(@PathVariable Integer userId, @PathVariable Integer bookId) {
        return favoriteBooksService.addFavoriteBooks(userId, bookId);
    }

    @Override
    @PutMapping("/favorites/{id}")
    public FavoriteBooksModelDto editFavoriteBooks(@RequestBody FavoriteBooksModelDto favoriteBooksModelDto) {
        return favoriteBooksService.editFavoriteBooks(favoriteBooksModelDto);
    }

    /**
     * Elimina libro favorito de un usuario
     */
    @Override
    @DeleteMapping("/favorites/{userId}/{bookId}")
    public boolean deleteFavoriteBooksById(@PathVariable Integer userId, @PathVariable Integer bookId) {
        return favoriteBooksService.deleteFavoriteBooksById(userId, bookId);
    }

    /**
     * Obtiene ID de libro favorito de un usuario
     */
    @Override
    @GetMapping("/favorites/{userId}/{bookId}")
    public Integer findByUserIdAndBookId(@PathVariable Integer userId, @PathVariable Integer bookId) {
        return favoriteBooksService.findByUserIdAndBookId(userId, bookId);
    }
}

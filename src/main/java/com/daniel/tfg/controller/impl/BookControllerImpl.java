package com.daniel.tfg.controller.impl;

import com.daniel.tfg.controller.BookController;
import com.daniel.tfg.model.dto.BookModelDto;
import com.daniel.tfg.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que maneja las distintas peticiones relacionadas con libros
 */
@RestController
@RequestMapping("/api/v1")
public class BookControllerImpl implements BookController {

    @Autowired
    private BookService bookService;

    /**
     * Obtiene todos los libros
     */
    @Override
    @GetMapping("/books")
    public List<BookModelDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    /**
     * Obtiene libro por ID
     */
    @Override
    @GetMapping("/books/{id}")
    public BookModelDto getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    /**
     * Añade libro nuevo
     */
    @Override
    @PostMapping("/books")
    public BookModelDto addBook(@RequestBody BookModelDto bookModelDto) {
        return bookService.addBook(bookModelDto);
    }

    /**
     * Edita libro por ID
     */
    @Override
    @PutMapping("/books/{id}")
    public BookModelDto editBook(@RequestBody BookModelDto bookModelDto) {
        return bookService.editBook(bookModelDto);
    }

    /**
     * Elimina libro por ID
     */
    @Override
    @DeleteMapping("/books/{id}")
    public boolean deleteBookById(@PathVariable Integer id) {
        return bookService.deleteBookById(id);
    }
}

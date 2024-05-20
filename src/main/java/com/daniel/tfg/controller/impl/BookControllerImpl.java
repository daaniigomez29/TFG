package com.daniel.tfg.controller.impl;

import com.daniel.tfg.controller.BookController;
import com.daniel.tfg.model.dto.BookModelDto;
import com.daniel.tfg.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookControllerImpl implements BookController {

    @Autowired
    private BookService bookService;
    @Override
    @GetMapping("/books")
    public List<BookModelDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @Override
    @GetMapping("/books/{id}")
    public BookModelDto getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    @Override
    @PostMapping("/books")
    public BookModelDto addBook(@RequestBody BookModelDto bookModelDto) {
        return bookService.addBook(bookModelDto);
    }

    @Override
    @PutMapping("/books/{id}")
    public BookModelDto editBook(@RequestBody BookModelDto bookModelDto) {
        return bookService.editBook(bookModelDto);
    }

    @Override
    @DeleteMapping("/books/{id}")
    public boolean deleteBookById(@PathVariable Integer id) {
        return bookService.deleteBookById(id);
    }
}

package com.daniel.tfg.service;

import com.daniel.tfg.model.dto.BookModelDto;

import java.util.List;

public interface BookService {
    public List<BookModelDto> getAllBooks();
    public BookModelDto getBookById(Integer id);
    public BookModelDto addBook(BookModelDto bookModelDto);
    public BookModelDto editBook(BookModelDto bookModelDto);
    public boolean deleteBookById(Integer id);
}

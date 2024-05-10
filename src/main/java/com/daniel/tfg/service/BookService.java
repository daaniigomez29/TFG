package com.daniel.tfg.service;

import com.daniel.tfg.model.dto.BookModelDto;

public interface BookService {
    public BookModelDto getAllBooks();
    public BookModelDto getBookById();
    public BookModelDto addBook(BookModelDto bookModelDto);
    public BookModelDto editBook(BookModelDto bookModelDto);
    public BookModelDto deleteBookById(Integer id);
}

package com.daniel.tfg.service.impl;

import com.daniel.tfg.exception.GlobalException;
import com.daniel.tfg.model.BookModel;
import com.daniel.tfg.model.dto.BookModelDto;
import com.daniel.tfg.repository.BookRepository;
import com.daniel.tfg.service.BookService;
import com.daniel.tfg.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository; //Repositorio de la tabla BookModel
    @Autowired
    private Mapper modelMapper;

    /**
     * Obtiene todos los libros de la bbdd
     * @return Lista con todos los libros mapeados a DTO
     */
    @Override
    public List<BookModelDto> getAllBooks() {
        return bookRepository.findAll().stream().map(bookModel -> modelMapper.toBookDto(bookModel)).collect(Collectors.toList());
    }

    /**
     * Obtiene libro encontrado por ID
     * @param id ID del libro
     * @return Libro mapeado a DTO
     */
    @Override
    public BookModelDto getBookById(Integer id) {
        Optional<BookModel> bookModel = bookRepository.findById(id);
        return bookModel.map(model -> modelMapper.toBookDto(model)).orElse(null);
    }

    /**
     * Añade libro a la bbdd
     * @param bookModelDto BookModelDto que contiene la información a añadir
     * @return BookModelDto
     */
    @Override
    public BookModelDto addBook(BookModelDto bookModelDto) {
        return modelMapper.toBookDto(bookRepository.save(modelMapper.toBook(bookModelDto)));
    }

    /**
     * Edita libro existente de la bbdd comprobando previamente que el libro exista
     * @param bookModelDto Contiene la información a editar del libro
     * @return BookModelDto
     */
    @Override
    public BookModelDto editBook(BookModelDto bookModelDto) {
        BookModel bookModel = bookRepository.findById(bookModelDto.getId()).orElse(null);
        if(bookModel != null){
            return modelMapper.toBookDto(bookRepository.save(modelMapper.toBook(bookModelDto)));
        } else{
            throw new GlobalException("El libro no existe");
        }
    }

    /**
     * Elimina libro de la bbdd con el ID
     * @param id ID del libro
     * @return verdadero si se ha borrado, si no, false
     */
    @Override
    public boolean deleteBookById(Integer id) {
        BookModel bookModel = bookRepository.findById(id).orElse(null);
        if (bookModel != null){
            bookRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }
}

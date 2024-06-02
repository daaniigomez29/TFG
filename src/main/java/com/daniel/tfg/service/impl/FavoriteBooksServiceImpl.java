package com.daniel.tfg.service.impl;

import com.daniel.tfg.exception.GlobalException;
import com.daniel.tfg.model.BookModel;
import com.daniel.tfg.model.FavoriteBooksModel;
import com.daniel.tfg.model.UserModel;
import com.daniel.tfg.model.dto.FavoriteBooksModelDto;
import com.daniel.tfg.model.dto.FavoriteBooksModelDtoWUser;
import com.daniel.tfg.repository.BookRepository;
import com.daniel.tfg.repository.FavoriteBooksRepository;
import com.daniel.tfg.repository.UserRepository;
import com.daniel.tfg.service.FavoriteBooksService;
import com.daniel.tfg.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteBooksServiceImpl implements FavoriteBooksService {

    @Autowired //Inyecta dependencia de la clase
    private FavoriteBooksRepository favoriteBooksRepository; //Repositorio de la bbdd de libros favoritos
    @Autowired
    private UserRepository userRepository; //Repositorio de la bbdd de usuarios
    @Autowired
    private BookRepository bookRepository; //Repositorio de la bbdd de libros
    @Autowired
    private Mapper modelMapper;

    /**
     * Devuelve todos los libros favoritos de un usuario
     * @param id ID del usuario
     * @return Lista de todos los libros favoritos mapeados a BookModelDto
     */
    @Override
    public List<FavoriteBooksModelDtoWUser> getAllFavoriteBooksOfUser(Integer id) {
        UserModel userFound = userRepository.findById(id).orElse(null);
        if(userFound != null){
          return favoriteBooksRepository.obtainAllFavoriteBooks(userFound).stream().map(favoriteBooksModel -> modelMapper.toFavoriteDtoWUser(favoriteBooksModel)).collect(Collectors.toList());
        } else {
            throw new GlobalException("El usuario no existe");
        }
    }

    @Override
    public FavoriteBooksModelDto getFavoriteBookById() {
        return null;
    }

    /**
     * Añade libro favorito a la bbdd comprobando que el usuario y el libro existan y que la relacion entre los 2 no exista
     * @param userId ID del usuario
     * @param bookId ID del libro
     * @return Objeto Mapeado a FavoriteBooksModelDto
     */
    @Override
    public FavoriteBooksModelDto addFavoriteBooks(Integer userId, Integer bookId) {
        UserModel userModel = userRepository.findById(userId).orElseThrow(() -> new GlobalException("El usuario no existe")); //Comprueba que el usuario exista
        BookModel bookModel = bookRepository.findById(bookId).orElseThrow(() -> new GlobalException("El libro no existe")); //Comprueba que el libro exista

        FavoriteBooksModel favoriteBooksModelFound = favoriteBooksRepository.findByUserModelIdAndBookModelId(userId, bookId).orElse(null); //Comprueba que el libro no haya sido marcado como favorito

        if(favoriteBooksModelFound == null){
            FavoriteBooksModel favoriteBooksModel = new FavoriteBooksModel();
            favoriteBooksModel.setUserModel(userModel);
            favoriteBooksModel.setBookModel(bookModel);


            return modelMapper.toFavoriteDto(favoriteBooksRepository.save(favoriteBooksModel));
        } else{
            throw new GlobalException("Este libro ya ha sido marcado como favorito");
        }
    }

    @Override
    public FavoriteBooksModelDto editFavoriteBooks(FavoriteBooksModelDto favoriteBooksModelDto) {
        return null;
    }

    /**
     * Elimina el libro de favoritos, eliminando la columna de la bbdd
     * @param userId ID del usuario
     * @param bookId ID del libro
     * @return true si se elimina, false si no
     */
    @Override
    public boolean deleteFavoriteBooksById(Integer userId, Integer bookId) {
        Integer favoriteId = findByUserIdAndBookId(userId, bookId);

        if(favoriteId != null){
            favoriteBooksRepository.deleteById(favoriteId);
            return true;
        } else{
            return false;
        }
    }

    /**
     * Encuenta el id de la columna de la tabla de la bbdd en la que coincida que x usuario tiene de favorito a x libro
     * @param userId ID del usuario
     * @param bookId ID del libro
     * @return ID de la columna de la tabla Favorite_Books
     */
    @Override
    public Integer findByUserIdAndBookId(Integer userId, Integer bookId) {
        FavoriteBooksModel favoriteBooksModel = favoriteBooksRepository.findByUserModelIdAndBookModelId(userId, bookId).orElseThrow(() -> new GlobalException("Este libro no se encuentra en favoritos"));

        return favoriteBooksModel.getId();
    }
}

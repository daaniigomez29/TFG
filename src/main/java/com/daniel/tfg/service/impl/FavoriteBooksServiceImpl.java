package com.daniel.tfg.service.impl;

import com.daniel.tfg.exception.GlobalException;
import com.daniel.tfg.exception.UserInvalidException;
import com.daniel.tfg.model.BookModel;
import com.daniel.tfg.model.FavoriteBooksModel;
import com.daniel.tfg.model.UserModel;
import com.daniel.tfg.model.dto.FavoriteBooksModelDto;
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

    @Autowired
    private FavoriteBooksRepository favoriteBooksRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private Mapper modelMapper;
    @Override
    public List<FavoriteBooksModelDto> getAllFavoriteBooksOfUser(Integer id) {
        UserModel userFound = userRepository.findById(id).orElse(null);
        if(userFound != null){
          return favoriteBooksRepository.obtainAllFavoriteBooks(userFound).stream().map(favoriteBooksModel -> modelMapper.toFavoriteDto(favoriteBooksModel)).collect(Collectors.toList());
        } else {
            throw new UserInvalidException();
        }
    }

    @Override
    public FavoriteBooksModelDto getFavoriteBookById() {
        return null;
    }

    @Override
    public FavoriteBooksModelDto addFavoriteBooks(Integer userId, Integer bookId) {
        UserModel userModel = userRepository.findById(userId).orElseThrow(UserInvalidException::new);
        BookModel bookModel = bookRepository.findById(bookId).orElseThrow(() -> new GlobalException("El libro no existe"));

        FavoriteBooksModel favoriteBooksModel = new FavoriteBooksModel();
        favoriteBooksModel.setUserModel(userModel);
        favoriteBooksModel.setBookModel(bookModel);


        return modelMapper.toFavoriteDto(favoriteBooksRepository.save(favoriteBooksModel));
    }

    @Override
    public FavoriteBooksModelDto editFavoriteBooks(FavoriteBooksModelDto favoriteBooksModelDto) {
        return null;
    }

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

    @Override
    public Integer findByUserIdAndBookId(Integer userId, Integer bookId) {
        FavoriteBooksModel favoriteBooksModel = favoriteBooksRepository.findByUserModelIdAndBookModelId(userId, bookId).orElseThrow(() -> new GlobalException("Este libro no se encuentra en favoritos"));

        return favoriteBooksModel.getId();
    }
}

package com.daniel.tfg.service.impl;

import com.daniel.tfg.exception.UserInvalidException;
import com.daniel.tfg.model.UserModel;
import com.daniel.tfg.model.dto.BookModelDto;
import com.daniel.tfg.model.dto.FavoriteBooksModelDto;
import com.daniel.tfg.model.dto.UserModelDto;
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
    public FavoriteBooksModelDto addFavoriteBooks(FavoriteBooksModelDto favoriteBooksModelDto) {
        return modelMapper.toFavoriteDto(favoriteBooksRepository.save(modelMapper.toFavorite(favoriteBooksModelDto)));
    }

    @Override
    public FavoriteBooksModelDto editFavoriteBooks(FavoriteBooksModelDto favoriteBooksModelDto) {
        return null;
    }

    @Override
    public boolean deleteFavoriteBooksById(Integer id) {
        FavoriteBooksModelDto favoriteBooksModelDto = modelMapper.toFavoriteDto(favoriteBooksRepository.findById(id).orElse(null));

        if(favoriteBooksModelDto != null){
            favoriteBooksRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }
}

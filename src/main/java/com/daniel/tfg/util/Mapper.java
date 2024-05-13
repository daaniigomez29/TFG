package com.daniel.tfg.util;


import com.daniel.tfg.model.*;
import com.daniel.tfg.model.dto.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

@Component
@RequiredArgsConstructor
public class Mapper {

    private final ModelMapper modelMapper;


    public UserModelDto toUserDTO(UserModel user){
        return modelMapper.map(user, UserModelDto.class);
    }
    public UserModel toUser(UserModelDto userDTO){
        return modelMapper.map(userDTO, UserModel.class);
    }

    public BookModelDto toBookDto(BookModel bookModel){return modelMapper.map(bookModel, BookModelDto.class);}
    public BookModel toBook(BookModelDto bookModelDto){return modelMapper.map(bookModelDto, BookModel.class);}

    public FavoriteBooksModelDto toFavoriteDto(FavoriteBooksModel favoriteBooksModel){return modelMapper.map(favoriteBooksModel, FavoriteBooksModelDto.class);}
    public FavoriteBooksModel toFavorite(FavoriteBooksModelDto favoriteBooksModelDto){return modelMapper.map(favoriteBooksModelDto, FavoriteBooksModel.class);}

    public RequestFriendModelDto toRequestDto(RequestFriendModel requestFriendModel){return modelMapper.map(requestFriendModel, RequestFriendModelDto.class);}
    public RequestFriendModel toRequest(RequestFriendModelDto requestFriendModelDto){return modelMapper.map(requestFriendModelDto, RequestFriendModel.class);}

    public FriendsModelDto toFriendsDto(FriendsModel friendsModel){return modelMapper.map(friendsModel, FriendsModelDto.class);}
    public FriendsModel toFriends(FriendsModelDto friendsModelDto){return modelMapper.map(friendsModelDto, FriendsModel.class);}






}

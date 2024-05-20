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
    public UserModelDtoFriends toUserDTOFriend(UserModel user){
        return modelMapper.map(user, UserModelDtoFriends.class);
    }
    public UserModelDtoFriends toUserDTOFriend(UserModelDto userModelDto){
        return modelMapper.map(userModelDto, UserModelDtoFriends.class);
    }

    public BookModelDto toBookDto(BookModel bookModel){return modelMapper.map(bookModel, BookModelDto.class);}
    public BookModel toBook(BookModelDto bookModelDto){return modelMapper.map(bookModelDto, BookModel.class);}

    public FavoriteBooksModelDto toFavoriteDto(FavoriteBooksModel favoriteBooksModel){return modelMapper.map(favoriteBooksModel, FavoriteBooksModelDto.class);}
    public FavoriteBooksModelDtoWUser toFavoriteDtoWUser(FavoriteBooksModel favoriteBooksModel){return modelMapper.map(favoriteBooksModel, FavoriteBooksModelDtoWUser.class);}

    public FavoriteBooksModel toFavorite(FavoriteBooksModelDto favoriteBooksModelDto){return modelMapper.map(favoriteBooksModelDto, FavoriteBooksModel.class);}

    public RequestFriendModelDto toRequestDto(RequestFriendModel requestFriendModel){return modelMapper.map(requestFriendModel, RequestFriendModelDto.class);}
    public RequestFriendModelDtoWUserReceive toRequestDtoWUserReceive(RequestFriendModel requestFriendModel){return modelMapper.map(requestFriendModel, RequestFriendModelDtoWUserReceive.class);}

    public RequestFriendModel toRequest(RequestFriendModelDto requestFriendModelDto){return modelMapper.map(requestFriendModelDto, RequestFriendModel.class);}

    
}

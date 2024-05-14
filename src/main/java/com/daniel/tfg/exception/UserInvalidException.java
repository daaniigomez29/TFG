package com.daniel.tfg.exception;

public class UserInvalidException extends RuntimeException {
    public UserInvalidException(){
        super("El usuario no existe");
    }
}

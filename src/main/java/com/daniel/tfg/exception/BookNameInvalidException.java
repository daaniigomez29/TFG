package com.daniel.tfg.exception;

public class BookNameInvalidException extends RuntimeException {

    public BookNameInvalidException(){
        super("El libro ya existe");
    }
}

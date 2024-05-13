package com.daniel.tfg.exception;

public class EmailInvalidException extends RuntimeException{

     public EmailInvalidException(){
        super("El email ya está registrado");
    }
}

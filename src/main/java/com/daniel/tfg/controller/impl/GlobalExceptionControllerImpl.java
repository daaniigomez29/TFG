package com.daniel.tfg.controller.impl;

import com.daniel.tfg.controller.GlobalExceptionController;
import com.daniel.tfg.exception.GlobalException;
import com.daniel.tfg.exception.TokenExpiredException;
import com.daniel.tfg.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * Controlador que maneja las distintas repuestas de error
 */
@RestControllerAdvice
public class GlobalExceptionControllerImpl implements GlobalExceptionController {

	/**
	 * Crea respuesta con el mensaje y la fecha de la excepcion
	 */
	@ExceptionHandler(GlobalException.class)
	public ResponseEntity<ApiError> handleElementNotFoundException(GlobalException e){
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}

	@ExceptionHandler(TokenExpiredException.class)
	public ResponseEntity<ApiError> handleTokenExpiredException(TokenExpiredException ex, WebRequest request) {
		String errorMessage = ex.getMessage();
		ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED, errorMessage);
		return new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
	}

}

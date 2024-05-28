package com.daniel.tfg.controller.impl;

import com.daniel.tfg.controller.GlobalExceptionController;
import com.daniel.tfg.exception.GlobalException;
import com.daniel.tfg.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionControllerImpl implements GlobalExceptionController {
	
	@ExceptionHandler(GlobalException.class)
	public ResponseEntity<ApiError> handleElementNotFoundException(GlobalException e){
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
		
	}

}

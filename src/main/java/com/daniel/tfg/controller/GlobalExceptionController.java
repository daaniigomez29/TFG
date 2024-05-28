package com.daniel.tfg.controller;

import com.daniel.tfg.exception.GlobalException;
import com.daniel.tfg.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public interface GlobalExceptionController {

	public ResponseEntity<ApiError> handleElementNotFoundException(GlobalException e);

}

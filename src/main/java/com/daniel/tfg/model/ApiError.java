package com.daniel.tfg.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * Clase que maneja el estado de la petición, la fecha y hora y el mensaje que luego recibe el usuario a la hora de hacer la petición si ocurre algún error
 */
public class ApiError {
	
	private HttpStatus status;
	
	@JsonFormat(shape= Shape.STRING, pattern="dd/MM/yyy hh:mm:ss")
	private LocalDateTime date;
	
	private String message;

	public ApiError(HttpStatus status, String message) {
		super();
		this.status = status;
		this.date = LocalDateTime.now();
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}

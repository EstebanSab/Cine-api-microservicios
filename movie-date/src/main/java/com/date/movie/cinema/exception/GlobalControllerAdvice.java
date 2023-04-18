package com.date.movie.cinema.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice{

    
  @ExceptionHandler(DateTimeTheaterException.class)
	public ResponseEntity<ErrorDetails> handleDateTimeTheaterException(DateTimeTheaterException dateTimeException){
		ErrorDetails error = new ErrorDetails(HttpStatus.CONFLICT, dateTimeException.getMessage());
        
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleObjectNotFoundException(ObjectNotFoundException notFoundException){
		ErrorDetails error = new ErrorDetails(HttpStatus.NOT_FOUND, notFoundException.getMessage());
        
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
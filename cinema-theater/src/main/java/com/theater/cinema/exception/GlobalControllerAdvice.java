package  com.theater.cinema.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice{

  @ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleObjectNotFoundException(ObjectNotFoundException notFoundException){
		ErrorDetails error = new ErrorDetails(HttpStatus.NOT_FOUND, notFoundException.getMessage());
        
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
package com.spring.udemy.SpringRestFromUdemy.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.udemy.SpringRestFromUdemy.User.UserNotFoundException;
//import com.spring.udemy.SpringRestFromUdemy.User.ValueNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEnttityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleALlException(Exception ex, WebRequest request) throws Exception {

		ExceptionResponse response = 
				new ExceptionResponse(new Date(),
						ex.getMessage(), 
						request.getDescription(false));
		return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFOundException(UserNotFoundException ex, WebRequest request) throws Exception {

		ExceptionResponse response = 
				new ExceptionResponse(new Date(),
						ex.getMessage(), 
						request.getDescription(false));
		return new ResponseEntity(response, HttpStatus.NOT_FOUND);

	}
	/*
	 * @ExceptionHandler(ValueNotFoundException.class) public final
	 * ResponseEntity<Object> handleValueNotFOundException(ValueNotFoundException
	 * ex, WebRequest request) throws Exception {
	 * 
	 * ExceptionResponse response = new ExceptionResponse(new Date(),
	 * ex.getMessage(), request.getDescription(false)); return new
	 * ResponseEntity(response, HttpStatus.UNPROCESSABLE_ENTITY);
	 * 
	 * }
	 */
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse response = new ExceptionResponse(new Date(), "Validation Failed",
				ex.getBindingResult().toString());
		return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
	}

}

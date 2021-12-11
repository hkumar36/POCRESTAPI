package com.poc.restAPI.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.poc.restAPI.exception.EmptyInputException;

@ControllerAdvice
public class GlobalControllerAdvice {
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyException(EmptyInputException emptyInputException){
		return new ResponseEntity<String>("Input is empty, Please try again with input",HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> genericException(Exception exception){
		exception.printStackTrace();
		return new ResponseEntity<String>("Please try again, Something went wrong!",HttpStatus.BAD_REQUEST);
	}

}

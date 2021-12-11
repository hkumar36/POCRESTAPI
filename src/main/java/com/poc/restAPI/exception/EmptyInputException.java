package com.poc.restAPI.exception;

public class EmptyInputException extends RuntimeException {

	private String message;
	private String code;
	
	public EmptyInputException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmptyInputException(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	
}

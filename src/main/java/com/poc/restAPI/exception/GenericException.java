package com.poc.restAPI.exception;

public class GenericException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private String code;
	
	public GenericException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GenericException(String message, String code) {
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

package com.poc.restAPI.validator;

import com.poc.restAPI.exception.EmptyInputException;
import  com.poc.restAPI.util.Constants;
import java.util.List;

public class Validator {
	public static <T> void validateInput(List<T> input){
		if(null == input || input.size() == 0) {
			throw new EmptyInputException(Constants.BLANK_MESSAGE,Constants.BLANK);
		}
	}
	
	public static <T> void validateInput(T input) {
		if(null == input) {
			throw new EmptyInputException(Constants.BLANK_MESSAGE,Constants.BLANK);
		}
	}
	
}

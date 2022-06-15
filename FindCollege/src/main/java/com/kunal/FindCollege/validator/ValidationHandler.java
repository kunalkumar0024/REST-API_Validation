package com.kunal.FindCollege.validator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Map<String,String> errors=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName=((FieldError)error).getField();
			String message=error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
	}

	//@ExceptionHandler(MethodArgumentNotValidException.class)
	//@Override
//	public ResponseEntity<Map<String,String>>
//	               handleMethodArgumentNotValidException
//	                              (MethodArgumentNotValidException ex,HttpHeaders headers,
//	                            		                      HttpStatus status, WebRequest request){
//		Map<String,String> errors=new HashMap<>();
//		ex.getBindingResult().getAllErrors().forEach((error)->{
//			String fieldName=((FieldError)error).getField();
//			String message=error.getDefaultMessage();
//			errors.put(fieldName, message);
//		});
//		return new ResponseEntity<Map<String,String>>(errors,HttpStatus.BAD_REQUEST);
//	}
}

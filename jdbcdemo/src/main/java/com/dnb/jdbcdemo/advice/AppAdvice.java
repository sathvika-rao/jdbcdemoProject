package com.dnb.jdbcdemo.advice;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.UnsupportedMediaType;
import org.springframework.web.context.request.WebRequest;

import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;

@ControllerAdvice
public class AppAdvice {
	
	//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "invalid id provided")
	
	//@ExceptionHandler(Exception.class)
	//@ExceptionHandler(TypeMismatch?.class)
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		Map<Object, Object> responseBody = new LinkedHashMap<>();
		responseBody.put("timestamp", LocalDateTime.now());
		responseBody.put("status", status.value());
		
		List<Object> errors = e.getBindingResult().getFieldErrors()
				.stream()
				.map(x -> x.getRejectedValue())
				.collect(Collectors.toList());
		
		List<String> fields = e.getBindingResult().getFieldErrors()
				.stream()
				.map(x -> x.getField())
				.collect(Collectors.toList());
		
		Map<String, Object> abc = new LinkedHashMap<>();
		for(int i=0;i<errors.size();i++) {
			abc.put(fields.get(i),errors.get(i));
		}
		
		
		responseBody.put("errors", abc);
		
		
		
		return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	
	public ResponseEntity<?> idNotFoundExceptionHandler(IdNotFoundException e) {
		Map<String,String> map = new HashMap<>();
		map.put("message", e.getMessage());
		map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
		return new ResponseEntity(map, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Map<String, String>> handleException (HttpRequestMethodNotSupportedException e) throws IOException{
		String provided = e.getMethod();
		List<String> supported = List.of(e.getSupportedMethods());
		String error = provided + " is not of the supported Http Methods (" + String.join(", ", supported) + ")";
		Map<String, String> errorResponse = Map.of(
				"error" , error,
				"message" , e.getLocalizedMessage(),
				"status", HttpStatus.METHOD_NOT_ALLOWED.toString()
				);
		return new ResponseEntity<>(errorResponse, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	
	@ExceptionHandler(InvalidContactNumberException.class)
	public ResponseEntity<?>  invalidContactNumberException(InvalidContactNumberException e){
		Map<String,String> map = new HashMap<>();
		map.put("message", e.getMessage());
		map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
		return new ResponseEntity(map, HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	
}

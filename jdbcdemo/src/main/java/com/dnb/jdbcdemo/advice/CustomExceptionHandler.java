package com.dnb.jdbcdemo.advice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		Map<Object, Object> responseBody = new LinkedHashMap<>();
		responseBody.put("timestamp", LocalDateTime.now());
		responseBody.put("status", status.value());
		
		List<Object> errors = ex.getBindingResult().getFieldErrors()
				.stream()
				.map(x -> x.getRejectedValue())
				.collect(Collectors.toList());
		
		List<String> fields = ex.getBindingResult().getFieldErrors()
				.stream()
				.map(x -> x.getField())
				.collect(Collectors.toList());
		
		Map<String, Object> abc = new LinkedHashMap<>();
		for(int i=0;i<errors.size();i++) {
			abc.put(fields.get(i),errors.get(i));
		}
		
		
		responseBody.put("errors", abc);
		
		
		
		return new ResponseEntity<>(responseBody, headers, status);
	}
	
}

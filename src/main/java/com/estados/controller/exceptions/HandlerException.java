package com.estados.controller.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.estados.service.exceptions.NotFoundException;
import com.estados.service.exceptions.ParamInvalidException;

@ControllerAdvice
public class HandlerException {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ApiError> notfound(NotFoundException ex, HttpServletRequest request){
		ApiError apiError = new ApiError(Instant.now(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), 
				ex.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
	
	@ExceptionHandler(ParamInvalidException.class)
	public ResponseEntity<ApiError> paramInvalid(ParamInvalidException ex, HttpServletRequest request){
		ApiError apiError = new ApiError(Instant.now(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_GATEWAY.getReasonPhrase(),
				ex.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
}

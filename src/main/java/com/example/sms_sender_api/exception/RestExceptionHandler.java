package com.example.sms_sender_api.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.twilio.exception.ApiException;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ApiException.class })
	public ResponseEntity<ExceptionDetails> handlerException(ApiException e) {
		ExceptionDetails details = new ExceptionDetails(e.getMessage(), LocalDateTime.now(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getClass().getName());
		return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { IllegalArgumentException.class })
	public ResponseEntity<ExceptionDetails> handlerException(IllegalArgumentException e) {
		ExceptionDetails details = new ExceptionDetails(e.getMessage(), LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(), e.getClass().getName());
		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<ExceptionDetails> handlerException(Exception e) {
		ExceptionDetails details = new ExceptionDetails("Ocorreu um erro " + e.getMessage(),
				LocalDateTime.now(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getClass().getName());
		return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

package com.learn.cursomc.resources.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.learn.cursomc.services.exceptions.DataIntegrityException;
import com.learn.cursomc.services.exceptions.ObjectNotFoundException;
import com.learn.cursomc.utils.format.FormatUtils;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e) {
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), getFormatDate());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e) {
		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), getFormatDate());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e) {
		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação.", getFormatDate());
		for(FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	private String getFormatDate() {
		return FormatUtils.formatDate(new Date(), FormatUtils.separator_slash_DDMMYYHHMMSSML);
	}
}
package com.certainhackathon.common.controller;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.NestableRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.certainhackathon.common.controller.view.ErrorResponse;

public class AbstractController {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractController.class);
	
	protected static final String DEFAULT_ERROR_MESSAGE = "An exception has occurred. If you continue to receive "
													  + "this error, contact the product support";
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
	    List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
	    List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
	    
	    Set<String> errors = new HashSet<String>();

	    for (FieldError fieldError : fieldErrors) {
	    	errors.add(fieldError.getDefaultMessage());
	    }
	    for (ObjectError objectError : globalErrors) {
	    	errors.add(objectError.getDefaultMessage());
	    }

	    return new ErrorResponse(errors);
	}
	
	@ExceptionHandler(NestableRuntimeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleNestableException(NestableRuntimeException ex) {
		LOG.error(ex.getMessage(), ex);
		return new ErrorResponse(ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorResponse handleException(Exception ex) {
		LOG.error(ex.getMessage(), ex);
		return new ErrorResponse(DEFAULT_ERROR_MESSAGE);
	}
		
	protected String getContextPath(){
		HttpServletRequest curRequest = 
				((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		
		return curRequest.getContextPath();
	}
}

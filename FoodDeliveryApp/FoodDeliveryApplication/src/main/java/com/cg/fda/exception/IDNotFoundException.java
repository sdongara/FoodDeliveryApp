package com.cg.fda.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IDNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public IDNotFoundException(String message) {
		super(message);
	}

}


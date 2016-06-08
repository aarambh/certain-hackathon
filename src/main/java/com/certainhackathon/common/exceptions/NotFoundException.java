package com.certainhackathon.common.exceptions;

import org.apache.commons.lang.exception.NestableRuntimeException;

public class NotFoundException extends NestableRuntimeException {

	private static final long serialVersionUID = -490094449842302L;

	public NotFoundException(Throwable root) {
		super(root);
	}
	
	public NotFoundException(String msg, Throwable root) {
		super(msg, root);
	}
	
	public NotFoundException(String msg) {
		super(msg);
	}
	
}

package com.te.ecommerce.exception;

@SuppressWarnings("serial")
public class CustomerException extends RuntimeException {
	
	final String errorMessage;
	
	public CustomerException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}

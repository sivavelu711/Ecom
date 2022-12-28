package com.te.ecommerce.exception;

public class CustomerException extends RuntimeException {
	
	String errorMessage;
	
	public CustomerException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}

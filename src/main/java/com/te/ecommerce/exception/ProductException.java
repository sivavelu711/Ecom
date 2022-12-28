package com.te.ecommerce.exception;

@SuppressWarnings("serial")
public class ProductException extends RuntimeException {
      String errorMessage;

	public ProductException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {	
		return errorMessage;
	}
}

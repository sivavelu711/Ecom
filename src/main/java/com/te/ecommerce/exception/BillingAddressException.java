package com.te.ecommerce.exception;

public class BillingAddressException extends RuntimeException {
	String errorMessage;

	public BillingAddressException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}


}

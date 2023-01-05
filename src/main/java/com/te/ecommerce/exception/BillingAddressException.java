package com.te.ecommerce.exception;

@SuppressWarnings("serial")
public class BillingAddressException extends RuntimeException {
	final String errorMessage;

	public BillingAddressException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}


}

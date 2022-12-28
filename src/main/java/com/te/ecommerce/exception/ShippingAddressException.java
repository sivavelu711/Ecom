package com.te.ecommerce.exception;

public class ShippingAddressException extends RuntimeException {
	String errorMessage;

	public ShippingAddressException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	

}

package com.te.ecommerce.exception;

public class CartItemException extends RuntimeException {
	String errorMessage;

	public CartItemException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
}
